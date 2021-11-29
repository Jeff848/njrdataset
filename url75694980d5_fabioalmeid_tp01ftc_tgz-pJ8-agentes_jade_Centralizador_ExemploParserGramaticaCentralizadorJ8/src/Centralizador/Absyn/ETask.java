package Centralizador.Absyn; // Java Package generated by the BNF Converter.

public class ETask extends Tarefa {
  public final Acao acao_;

  public ETask(Acao p1) { acao_ = p1; }

  public <R,A> R accept(Centralizador.Absyn.Tarefa.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Centralizador.Absyn.ETask) {
      Centralizador.Absyn.ETask x = (Centralizador.Absyn.ETask)o;
      return this.acao_.equals(x.acao_);
    }
    return false;
  }

  public int hashCode() {
    return this.acao_.hashCode();
  }


}