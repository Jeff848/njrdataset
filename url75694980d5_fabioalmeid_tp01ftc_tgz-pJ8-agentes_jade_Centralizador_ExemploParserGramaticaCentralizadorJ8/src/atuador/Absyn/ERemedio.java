package atuador.Absyn; // Java Package generated by the BNF Converter.

public class ERemedio extends Remedio {

  public ERemedio() { }

  public <R,A> R accept(atuador.Absyn.Remedio.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof atuador.Absyn.ERemedio) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}