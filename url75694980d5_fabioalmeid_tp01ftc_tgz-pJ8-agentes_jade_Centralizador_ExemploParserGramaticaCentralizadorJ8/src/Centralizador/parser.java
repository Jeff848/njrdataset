
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Sat Sep 14 19:11:48 AMT 2013
//----------------------------------------------------

package Centralizador;


/** CUP v0.10k generated parser.
  * @version Sat Sep 14 19:11:48 AMT 2013
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\024\000\002\002\004\000\002\003\003\000\002\004" +
    "\004\000\002\004\004\000\002\004\003\000\002\005\003" +
    "\000\002\005\003\000\002\006\003\000\002\006\003\000" +
    "\002\007\003\000\002\007\003\000\002\007\003\000\002" +
    "\007\003\000\002\007\005\000\002\010\003\000\002\011" +
    "\005\000\002\011\003\000\002\012\003\000\002\013\003" +
    "\000\002\013\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\014\004\010\005\007\006\006\011\004\015" +
    "\014\001\002\000\004\002\ufffd\001\002\000\012\007\026" +
    "\012\030\014\027\017\031\001\002\000\010\013\ufff9\016" +
    "\ufff9\021\ufff9\001\002\000\012\007\ufffb\012\ufffb\014\ufffb" +
    "\017\ufffb\001\002\000\012\007\ufffc\012\ufffc\014\ufffc\017" +
    "\ufffc\001\002\000\010\013\022\016\017\021\020\001\002" +
    "\000\004\002\015\001\002\000\004\002\000\001\002\000" +
    "\010\013\ufffa\016\ufffa\021\ufffa\001\002\000\004\002\001" +
    "\001\002\000\004\002\ufffe\001\002\000\004\002\uffee\001" +
    "\002\000\004\010\ufff0\001\002\000\004\002\ufff1\001\002" +
    "\000\004\002\uffef\001\002\000\004\010\024\001\002\000" +
    "\006\013\022\016\017\001\002\000\004\002\ufff2\001\002" +
    "\000\006\002\ufff5\020\ufff5\001\002\000\006\002\ufff7\020" +
    "\ufff7\001\002\000\006\002\ufff6\020\ufff6\001\002\000\006" +
    "\002\ufff8\020\ufff8\001\002\000\006\002\uffff\020\034\001" +
    "\002\000\012\007\026\012\030\014\027\017\031\001\002" +
    "\000\012\007\ufff3\012\ufff3\014\ufff3\017\ufff3\001\002\000" +
    "\006\002\ufff4\020\034\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\033\000\012\003\011\004\012\005\004\006\010\001" +
    "\001\000\002\001\001\000\004\007\031\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\010\011" +
    "\015\012\022\013\020\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\013\024\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\010\032\001" +
    "\001\000\004\007\034\001\001\000\002\001\001\000\004" +
    "\010\032\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



  public Centralizador.Absyn.Tarefa pTarefa() throws Exception
  {
	java_cup.runtime.Symbol res = parse();
	return (Centralizador.Absyn.Tarefa) res.value;
  }

public <B,A extends java.util.LinkedList<? super B>> A cons_(B x, A xs) { xs.addFirst(x); return xs; }

public void syntax_error(java_cup.runtime.Symbol cur_token)
{
	report_error("Syntax Error, trying to recover and continue parse...", cur_token);
}

public void unrecovered_syntax_error(java_cup.runtime.Symbol cur_token) throws java.lang.Exception
{
	throw new Exception("Unrecoverable Syntax Error");
}


}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // Remedio ::= _SYMB_10 
            {
              Centralizador.Absyn.Remedio RESULT = null;
		 RESULT = new Centralizador.Absyn.ERemedy2(); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*Remedio*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // Remedio ::= _SYMB_7 
            {
              Centralizador.Absyn.Remedio RESULT = null;
		 RESULT = new Centralizador.Absyn.ERemedy1(); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*Remedio*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // Quantidade ::= _INTEGER_ 
            {
              Centralizador.Absyn.Quantidade RESULT = null;
		Integer p_1 = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EQtde1(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*Quantidade*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // Medicacao ::= Remedio 
            {
              Centralizador.Absyn.Medicacao RESULT = null;
		Centralizador.Absyn.Remedio p_1 = (Centralizador.Absyn.Remedio)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EMedic2(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Medicacao*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // Medicacao ::= Quantidade _SYMB_4 Remedio 
            {
              Centralizador.Absyn.Medicacao RESULT = null;
		Centralizador.Absyn.Quantidade p_1 = (Centralizador.Absyn.Quantidade)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Centralizador.Absyn.Remedio p_3 = (Centralizador.Absyn.Remedio)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EMedic1(p_1,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*Medicacao*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // Operador ::= _SYMB_12 
            {
              Centralizador.Absyn.Operador RESULT = null;
		 RESULT = new Centralizador.Absyn.EOp(); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*Operador*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // Dados ::= Dados Operador Dados 
            {
              Centralizador.Absyn.Dados RESULT = null;
		Centralizador.Absyn.Dados p_1 = (Centralizador.Absyn.Dados)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		Centralizador.Absyn.Operador p_2 = (Centralizador.Absyn.Operador)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Centralizador.Absyn.Dados p_3 = (Centralizador.Absyn.Dados)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EData5(p_1,p_2,p_3); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*Dados*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // Dados ::= _SYMB_3 
            {
              Centralizador.Absyn.Dados RESULT = null;
		 RESULT = new Centralizador.Absyn.EData4(); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*Dados*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // Dados ::= _SYMB_6 
            {
              Centralizador.Absyn.Dados RESULT = null;
		 RESULT = new Centralizador.Absyn.EData3(); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*Dados*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // Dados ::= _SYMB_8 
            {
              Centralizador.Absyn.Dados RESULT = null;
		 RESULT = new Centralizador.Absyn.EData2(); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*Dados*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // Dados ::= _SYMB_11 
            {
              Centralizador.Absyn.Dados RESULT = null;
		 RESULT = new Centralizador.Absyn.EData1(); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*Dados*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // Aplicar ::= _SYMB_2 
            {
              Centralizador.Absyn.Aplicar RESULT = null;
		 RESULT = new Centralizador.Absyn.EApply2(); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*Aplicar*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // Aplicar ::= _SYMB_9 
            {
              Centralizador.Absyn.Aplicar RESULT = null;
		 RESULT = new Centralizador.Absyn.EApply1(); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*Aplicar*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // Coletar ::= _SYMB_1 
            {
              Centralizador.Absyn.Coletar RESULT = null;
		 RESULT = new Centralizador.Absyn.ECollect2(); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*Coletar*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // Coletar ::= _SYMB_0 
            {
              Centralizador.Absyn.Coletar RESULT = null;
		 RESULT = new Centralizador.Absyn.ECollect1(); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*Coletar*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // Acao ::= _SYMB_5 
            {
              Centralizador.Absyn.Acao RESULT = null;
		 RESULT = new Centralizador.Absyn.EAction3(); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Acao*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // Acao ::= Aplicar Medicacao 
            {
              Centralizador.Absyn.Acao RESULT = null;
		Centralizador.Absyn.Aplicar p_1 = (Centralizador.Absyn.Aplicar)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Centralizador.Absyn.Medicacao p_2 = (Centralizador.Absyn.Medicacao)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EAction2(p_1,p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Acao*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // Acao ::= Coletar Dados 
            {
              Centralizador.Absyn.Acao RESULT = null;
		Centralizador.Absyn.Coletar p_1 = (Centralizador.Absyn.Coletar)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		Centralizador.Absyn.Dados p_2 = (Centralizador.Absyn.Dados)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.EAction1(p_1,p_2); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*Acao*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // Tarefa ::= Acao 
            {
              Centralizador.Absyn.Tarefa RESULT = null;
		Centralizador.Absyn.Acao p_1 = (Centralizador.Absyn.Acao)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new Centralizador.Absyn.ETask(p_1); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*Tarefa*/, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= Tarefa EOF 
            {
              Object RESULT = null;
		Centralizador.Absyn.Tarefa start_val = (Centralizador.Absyn.Tarefa)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
