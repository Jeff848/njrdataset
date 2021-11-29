// ************************************************************************** //
// Personnel.java - This class is a member of the <B>counters</B> package, which     //
//                  contains the class definitions and implementations for    //
//                  objects used to represent the virtual playing pieces in   //
//                  jASL.                                                     //
//                                                                            //
//                  NOTE: This program is based on Advanced Squad Leader,     //
//                        which was created by The Avalon Hill Game Company,  //
//                        and lives on at <A HREF="http://www.multimanpublishing.com/Products/tabid/58/CategoryID/4/Default.aspx">MultimanPublishing.com</A>.             //
//                                                                            //
// Written By: Craig R. Campbell  -  December 1998                            //
// ************************************************************************** //

package jasl.counters;

import jasl.utilities.Messages;

/**
 * This class is used to define the characteristics which are common to all
 * infantry units that represent more than one combat soldier. In the board
 * game, these units are referred to as multi-man counters (MMC). This class is
 * intended strictly as a superclass, not to be instantiated directly.
 *
 * @version 5.2
 * @author Copyright (C) 1998-2016 Craig R. Campbell (craigonic@gmail.com)
 * @see <A HREF="../../../source/jasl/counters/Personnel.html">Source code</A>
 */

abstract class Personnel extends Infantry implements MaximumELR, Classification
{
	// Symbolic constants

	// These constants are used in the constructor to pass the correct value
	// of a Personnel unit (multi-man counter) for each attribute. Other
	// types of <A HREF="Unit.html">Unit</A>s may allow the calling program to set these values, but
	// they are the same for all MMCs. The movement allowance is reduced by
	// one if the unit is inexperienced (green or conscript) AND a leader is
	// not present.

	private static final int MOVEMENT_ALLOWANCE = 4;
	private static final int PORTAGE_CAPACITY = 3;
	private static final int PORTAGE_VALUE = 10;

	// Private data members

	// This variable is used to indicate that the unit that this object
	// represents is automatically given the <A HREF="ExperienceLevelRating.html#_MAX_ELR_">maximum ELR</A>. This flag affects
	// how the unit is replaced/reduced. It is indicated on the physical
	// counter by an underscored morale value.

	private boolean _hasMaximumELR;

	// The purpose of the classification variable is to describe the
	// experience level of the object that it represents. It applies only to
	// multi-man units (squads, crews, etc).

	private Classifications _classification;

	// The following strings are used as messages for any exceptions that
	// may be generated by bad data being passed to the constructor.

	// This constant is used as part of the error messages (see below) that
	// are generated when an exception is thrown.

	private static final String CLASS_NAME = Personnel.class.getSimpleName();

	private static final String invalidArgumentError =
		Messages.buildErrorMessage(CLASS_NAME,Messages.CONSTRUCTOR,
		                           Messages.INVALID_PARAMETER_MSG);
	// Constructor

	// During the instantiation of derived concrete classes the parameters
	// are passed up the inheritance tree from the constructor of the object
	// type being created.

	protected Personnel(Descriptions description,Nationalities nationality,
	                    InfantryTypes unitType,int firepower,
	                    int normalRange,int morale,int brokenMorale,
	                    boolean canSelfRally,int basicPointValue,
	                    int experienceLevelRating,boolean hasMaximumELR,
	                    Classifications classification)
	{
		// Pass the first 10 parameters to the superclass constructor.
		// Note that one or more variables has been set with symbolic
		// constants. These are defined at the beginning of this class
		// and its superclasses. If any exceptions are thrown, assume
		// that they will be caught and handled by the program creating
		// the object.

		super(description,nationality,unitType,MOVEMENT_ALLOWANCE,
		      PORTAGE_CAPACITY,firepower,normalRange,morale,
		      brokenMorale,canSelfRally,PORTAGE_VALUE,basicPointValue,
		      experienceLevelRating);

		// Check the value of the remaining parameter and copy the value
		// to the local copy of the corresponding variable if an
		// exception is not found.

		// Maximum ELR flag

		_hasMaximumELR = hasMaximumELR;

		// Classification

		if ((classification == Classifications.SS) &&
		    (nationality    != Nationalities.GERMAN))
		{
			throw new IllegalArgumentException(invalidArgumentError +
			                                   nationality.toString() +
			                                   Messages.AND_SEPARATOR +
			                                   classification.toString());
		}

		_classification = classification;
	}

	// Public access methods

	/**
	 * Display the value of each of the private data members that describe
	 * the current instance.
	 *
	 * All of the members, beginning with the top-level class (<B><A HREF="Unit.html">Unit</A></B>) and
	 * continuing down the hierarchy to this level, are appended to the
	 * returned string. Each value is preceded by a label defined in this
	 * class or the interface associated with the item. There are no more
	 * than two values, including labels, in each line of output.
	 *
	 * @return a multi-line tabular <CODE>String</CODE>, 80 characters wide.
	 */

	public String toText()
	{
		// Create a buffer to store the string to be returned,
		// initializing it with the string defined in the parent class
		// version of this method.

		StringBuffer returnString = new StringBuffer(super.toText());

		// Add the information describing the data stored in this class
		// instance.

		// Maximum ELR flag

		returnString.append(Messages.formatTextString(HAS_MAXIMUM_ELR_LABEL,
		                                              FIRST_COLUMN_LABEL_WIDTH,
		                                              true,false));

		returnString.append(Messages.formatTextString(Messages.getChoiceLabel(hasMaximumELR()),
		                                              SECOND_COLUMN_VALUE_WIDTH,
		                                              false,false));

		// Classification

		returnString.append(Messages.formatTextString(Classification.CLASSIFICATION_LABEL,
		                                              THIRD_COLUMN_LABEL_WIDTH,
		                                              true,false));

		returnString.append(Messages.formatTextString(classification(),
		                                              FOURTH_COLUMN_VALUE_WIDTH,
		                                              false,true));

		// Return the completed string to calling program.

		return returnString.toString();
	}

	/**
	 * Return an abbreviated description, including attributes, of a unit.
	 *
	 * The text includes the firepower, range, morale, and counter type. If
	 * an identity is set, it will also be included, shown in parentheses.
	 *
	 * @return a <CODE>String</CODE> specifying a simple description of the unit.
	 */

	public String toString()
	{
		// Create a buffer to store the string to be returned,
		// initializing it with the basic attributes of the unit.

		StringBuffer returnString =
			new StringBuffer(firepower() + "-" +
			                 Integer.toString(normalRange()) + "-" +
			                 Integer.toString(morale()));

		// Add the counter type.

		returnString.append(" " + description());

		// If the identity has been set, add it to the end of the
		// string, in parentheses.

		appendIdentity(returnString);

		// Return the completed string to calling program.

		return returnString.toString();
	}

	/**
	 * Display the JSON representation each of the private data members that
	 * describe the current instance.
	 *
	 * All of the members, beginning with the top-level class (<B><A HREF="Unit.html">Unit</A></B>) and
	 * continuing down the hierarchy to this level, are appended to the
	 * returned string. Each value is preceded by a label (key) defined in
	 * this class or the interface associated with the item. Entries at each
	 * level are successively indented to provide hierarchical formatting of
	 * the output.
	 *
	 * @return a <CODE>String</CODE> containing the JSON data.
	 */

	public String toJSON()
	{
		// Create a buffer to store the string to be returned,
		// initializing it with the string defined in the parent class
		// version of this method.

		StringBuffer returnString = new StringBuffer(super.toJSON());

		// Add the information describing the data stored in this class
		// instance.

		String INDENT = "     ";

		returnString.append(INDENT +
		                    buildJSONPair(HAS_MAXIMUM_ELR_LABEL,hasMaximumELR()) +
		                    JSON_OBJECT_SEPARATOR);
		returnString.append(INDENT +
		                    buildJSONPair(CLASSIFICATION_LABEL,classification()) +
		                    JSON_OBJECT_SEPARATOR);

		// Return the completed string to calling program.

		return returnString.toString();
	}

	/**
	 * Indicate if a unit inherently has the maximum experience level
	 * rating.
	 *
	 * This is used to determine how a unit is replaced. It is indicated on
	 * the physical counter by an underscored morale value.
	 *
	 * @return a <CODE>boolean</CODE> indicating if the unit has this attribute.
	 */

	public final boolean hasMaximumELR()
	{
		return _hasMaximumELR;
	}

	/**
	 * Return the classification of a unit.
	 *
	 * This is indicated on the front of the physical counter by an
	 * alphanumeric character in the upper right corner.
	 *
	 * @return a <CODE>String</CODE> specifying the unit classification.
	 */

	public final String classification()
	{
		return _classification.toString();
	}
}