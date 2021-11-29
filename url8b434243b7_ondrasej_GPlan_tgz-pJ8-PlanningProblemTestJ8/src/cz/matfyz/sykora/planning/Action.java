/*
    Copyright 2006 Ondrej Sykora
 
    This file is part of GPlan.

    GPlan is free software: you can redistribute it and/or modify it
    under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    GPlan is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with GPlan.  If not, see <http://www.gnu.org/licenses/>.
 */
package cz.matfyz.sykora.planning;

import java.io.IOException;
import java.util.*;

import cz.matfyz.sykora.planning.graph.*;
import cz.matfyz.sykora.planning.predicate.*;

/**
 * Representation of actions in the planning system. This class is used to
 * represent both fully instantiated actions and action schema.
 * 
 * @author Ondra Sykora [ondrasej@matfyz.cz]
 */
public class Action implements Comparable<Action> {
	/**
	 * Name of the action.
	 *
	 *	@see #getActionName()
	 */
	private String actionName;
	
	/**
	 * List of preconditions of the action. All unbound variables in the action
	 * must be referenced from at least one precondition predicate.
	 *
	 *	@see #getPreconditions()
	 *	@see ActionList#getPreconditions()
	 */
	private PredicateSet preconditions;
	
	private PredicateSet preconditionsFulfillers;

	/**
	 * List of negative effects of the action.
	 *
	 *	@see #getNegativeEffects()
	 */
	private PredicateSet negativeEffects;
	
	/**
	 * List of positive effects of the action.
	 *
	 *	@see #getPositiveEffects()
	 */
	private PredicateSet positiveEffects;
	
	/**
	 * Compares this action to another one.
	 *
	 *	@param _next the other action.
	 *	@return -1 if this action is "lower" than the other one, 0 when they
	 *		are equal and 1 when this action is "greater".
	 */
	public int compareTo(Action _next) {
		Action next_action = (Action)_next;
		
		int tmp = actionName.compareTo(next_action.actionName);
		if(tmp != 0)
			return tmp;
		tmp = preconditions.compareTo(next_action.preconditions);
		if(tmp != 0)
			return tmp;
		tmp = positiveEffects.compareTo(next_action.positiveEffects);
		if(tmp != 0)
			return tmp;
		tmp = negativeEffects.compareTo(next_action.negativeEffects);
		if(tmp != 0)
			return tmp;
		return positiveEffects.compareTo(next_action.positiveEffects);
	}
	
	/**
	 * Tests two actions for equality. Actions are equal if they have the same
	 * name and their preconditions, negative and positive effects are equal.
	 *
	 *	@return true if the predicates are equal.
	 */
	public boolean equals(Object _other_action) {
		if(_other_action == null
				|| !(_other_action instanceof Action))
			return false;
		Action other = (Action)_other_action;
		if(!getActionName().equals(other.getActionName()))
			return false;
		if(getPreconditions().getPredicateCount() != other.getPreconditions().getPredicateCount())
			return false;
		for(int i=0; i < getPreconditions().getPredicateCount(); i++)
			if(!getPreconditions().getPredicate(i).equals(other.getPreconditions().getPredicate(i)))
				return false;
		if(getPositiveEffects().getPredicateCount() != other.getPositiveEffects().getPredicateCount())
			return false;
		for(int i=0; i < getPositiveEffects().getPredicateCount(); i++)
			if(!getPositiveEffects().getPredicate(i).equals(other.getPositiveEffects().getPredicate(i)))
				return false;
		if(getNegativeEffects().getPredicateCount() != other.getNegativeEffects().getPredicateCount())
			return false;
		for(int i=0; i < getNegativeEffects().getPredicateCount(); i++)
			if(!getNegativeEffects().getPredicate(i).equals(other.getNegativeEffects().getPredicate(i)))
				return false;
		return true;
	}
	
	/**
	 * Finds all possible instances of the action based on it's preconditions
	 * and a predicate layer. This method is aware of mutexes on predicates
	 * and generates only actions that are consistent with them.
	 *
	 *	@param _predicate_layer predicate layer from that the action instances
	 * 		are generated.
	 *	@param _output set used to store actions generated by this method.
	 *	@see #findPossibleInstances(PredicateLayer, Set, Map)
	 */
	public void findPossibleInstances(PredicateLayer _predicate_layer, Set<Action> _output) {
		findPossibleInstances(_predicate_layer, _output, null);
	}
	
	/**
	 * Finds all possible instances of this action on a specified predicate
	 * layer.
	 * 
	 *	@param _predicate_layer predicate layer from that the action instances
	 * 		are generated.
	 *	@param _output set used to store generated actions.
	 *	@param _dependencies map of predicate-action dependencies that is used
	 *		to map predicates to actions they support.
	 */
	public void findPossibleInstances(PredicateLayer _predicate_layer, Set<Action> _output,
			Map<Predicate, ActionList> _dependencies) {
		preconditionsFulfillers = new PredicateSet();
		findPossibleInstances(_predicate_layer, 0, 0, _output, _dependencies);
	}
	
	/**
	 * Finds all possible instances of this action on a specified predicate
	 * layer. This method does the actual function instances lookup.
	 * 
	 *	@param _predicate_layer predicate layer from that the action instances
	 * 			are generated.
	 *	@param _pl_index index of the current predicate.
	 *	@param _preconds_index list of resolved preconditions.
	 *	@param _output set used to store generated actions.
	 *	@param _dependencies map of predicate-action dependencies that is used
	 *		to map predicates to actions they support.
	 */
	private void findPossibleInstances(PredicateLayer _predicate_layer,
			int _pl_index, int _preconds_index, Set<Action> _output,
			Map<Predicate, ActionList> _dependencies) {
		if(_preconds_index == preconditions.getPredicateCount()) {
			Action grounded_clone = groundedClone();
			if(!_output.contains(grounded_clone))
				_output.add(grounded_clone);
			if(_dependencies != null) {
				// mark new copy of the action dependent on its preconditions. This
				// is used later to recognize mutexes in actions.
				for(Predicate precondition : preconditionsFulfillers) {
					ActionList list = _dependencies.get(precondition);
					if(list == null) {
						list = new ActionList();
						_dependencies.put(precondition, list);
					}
					list.add(grounded_clone);
				}
			}
			return;
		}
		Predicate current_precondition = preconditions.getPredicate(_preconds_index);
		ArrayList<ValueBinding> unified_bindings = new ArrayList<ValueBinding>();
		for(;_pl_index < _predicate_layer.getPredicateCount(); _pl_index++) {
			Predicate current_fact = _predicate_layer.getPredicate(_pl_index);
			if(current_precondition.unifyWith(current_fact, unified_bindings)) {
				boolean mutex = false;
				for(Predicate fulfiller : preconditionsFulfillers)
					if(_predicate_layer.isMutex(fulfiller, current_precondition)
							|| _predicate_layer.isMutex(current_precondition, fulfiller)) {
						mutex = true;
						break;
					}
				if(!mutex) {
					preconditionsFulfillers.add(current_fact);
					findPossibleInstances(_predicate_layer, 0, _preconds_index + 1, _output, _dependencies);
					preconditionsFulfillers.remove(current_fact);
				}
			}
			for(ValueBinding binding : unified_bindings)
				binding.clear();
			unified_bindings.clear();
		}
	}
	
	/**
	 * Returns the action name.
	 *
	 *	@return the action name.
	 *	@see #actionName
	 */
	public String getActionName() {
		return actionName;
	}
	
	/**
	 * Returns list of negative effects of the action.
	 * 
	 *	@return list of negative effects of the action.
	 *	@see #negativeEffects
	 *	@see #getPositiveEffects()
	 *	@see #getPreconditions()
	 */
	public PredicateSet getNegativeEffects() {
		return negativeEffects;
	}
	
	/**
	 * Returns list of positive effects of the action.
	 * 
	 *	@return list of positive effects of the action.
	 *	@see #positiveEffects
	 *	@see #getNegativeEffects()
	 *	@see #getPreconditions()
	 */
	public PredicateSet getPositiveEffects() {
		return positiveEffects;
	}
	
	/**
	 * Returns list of preconditions of the action.
	 * 
	 *	@return list of predicates of the action.
	 *	@see #preconditions
	 *	@see #getNegativeEffects()
	 *	@see #getPositiveEffects()
	 */
	public PredicateSet getPreconditions() {
		return preconditions;
	}
	
	/**
	 * Creates a (grounded) clone of this action. This is used when
	 * instantiated actions are added to the action layer. Variable bindings
	 * in the clone are not dependent or linked to the source, thus they are
	 * not changed when variable binding of the source action is changed.
	 * 
	 * This method excepts that all variables in predicates and effects of the
	 * action are bound to solid values.
	 * 
	 *	@return clone of this actions with the same values.
	 */
	public Action groundedClone() {
		PredicateSet preconditions_clone = new PredicateSet();
		for(Predicate current : preconditions)
			preconditions_clone.add(current.groundedClone());
		
		PredicateSet negative_effects_clone = new PredicateSet();
		for(Predicate current : negativeEffects)
			negative_effects_clone.add(current.groundedClone());
		
		PredicateSet positive_effects_clone = new PredicateSet();
		for(Predicate current : positiveEffects)
			positive_effects_clone.add(current.groundedClone());
		
		return new Action(getActionName(), preconditions_clone, negative_effects_clone, positive_effects_clone);
	}
	
	/**
	 * Tests if all variables in preconditions and effects of the action are
	 * bound to solid values.
	 * 
	 *	@return if this action is grounded, false otherwise.
	 */
	public boolean isGrounded() {
		return preconditions.isGrounded()
			&& negativeEffects.isGrounded()
			&& positiveEffects.isGrounded();
	}
	
	/**
	 * Converts the action to it's string representation.
	 * 
	 *	@return string representation of the action.
	 */
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(getActionName());
		res.append(" :: ");
		boolean first = true;
		for(Predicate pred : preconditions) {
			if(!first)
				res.append(", ");
			else
				first = false;
			res.append(pred.toString());
		}
		
		res.append(" => ");
		
		first = true;
		for(Predicate pred : positiveEffects) {
			if(!first)
				res.append(", ");
			else
				first = false;
			res.append(pred.toString());
		}
		for(Predicate pred : negativeEffects) {
			if(!first)
				res.append(", ");
			else
				first = false;
			res.append("not ");
			res.append(pred.toString());
		}
		res.append('.');
		
//		return getActionName() + " :: " + 
//				preconditions.toString() + " -> +(" +
//				positiveEffects.toString() + ") -(" +
//				negativeEffects.toString() + ")";
		return res.toString();
	}
	
	/**
	 * Creates a no-op action for a single predicate. The no-op actions is used
	 * to hold a single predicate without performing any action. It is used to
	 * transfer predicates from one layer to another without need for a special
	 * mechanism that would bind these predicates in both layers.
	 * 
	 * The action has a single precondition which is the predicate that the
	 * action is supposed to represent.
	 * 
	 *	@param _predicate predicate for the no-op action.
	 *	@return a new no-op action that holds the predicate <i>_predicate</i>. 
	 */
	public static Action noOpAction(Predicate _predicate) {
		if(_predicate == null)
			throw new NullPointerException("_predicate parameter must not be null");
		if(!_predicate.isGrounded())
			throw new RuntimeException("_predicate must be grounded");
		
		PredicateSet preconditions = new PredicateSet();
		preconditions.add(_predicate.groundedClone());
		
		PredicateSet negative_effects = new PredicateSet();
		
		PredicateSet positive_effects = new PredicateSet();
		positive_effects.add(_predicate.groundedClone());
		
		return new Action("no-op", preconditions, negative_effects, positive_effects);
	}
	
	/**
	 * Creates a new action from it's string representation. This uses
	 * <i>PredicateParser</i> internally.
	 * 
	 *	@param _action_source string representation of the action.
	 *	@return a new instance of Action based on it's string representation.
	 *	@see PredicateParser
	 *	@see PredicateParser#parseAction()
	 */
	public static Action parse(String _action_source) {
		try {
			PredicateParser parser = new PredicateParser(_action_source);
			return parser.parseAction();
		}
		catch(IOException io_error) {
			System.err.println("There was an I/O error while parsing the predicate: " + io_error.getMessage());
			assert(false);
			return null;
		}
		catch(PredicateParser.TokenException token_error) {
			System.err.println("There was an error while parsing the predicate: " + token_error.getMessage());
			assert(false);
			return null;
		}
	}
	
	/**
	 * Constructor. Initializes an action with specified name, preconditions,
	 * positive and negative effects.
	 * 
	 *	@param _action_name
	 *	@param _preconditions
	 *	@param _negative_effects
	 *	@param _positive_effects
	 */
	public Action(String _action_name, PredicateSet _preconditions,
			PredicateSet _negative_effects, PredicateSet _positive_effects) {
		actionName = _action_name;
		preconditions = _preconditions;
		negativeEffects = _negative_effects;
		positiveEffects = _positive_effects;
	}
}
