package Centralizador.Absyn; // Java Package generated by the BNF Converter.

public class EApply2 extends Aplicar {

  public EApply2() { }

  public <R,A> R accept(Centralizador.Absyn.Aplicar.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof Centralizador.Absyn.EApply2) {
      return true;
    }
    return false;
  }

  public int hashCode() {
    return 37;
  }


}