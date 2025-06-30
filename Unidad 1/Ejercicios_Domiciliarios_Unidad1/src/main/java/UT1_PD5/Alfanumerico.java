package UT1_PD5;

public enum Alfanumerico {
    A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'), I('I'), J('J'),
    K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q('Q'), R('R'), S('S'), T('T'),
    U('U'), V('V'), W('W'), X('X'), Y('Y'), Z('Z'),
    CERO(0), UNO(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6), SIETE(7), OCHO(8), NUEVE(9);

    private final Character letra;
    private final Integer numero;


    Alfanumerico(char letra) {
        this.letra = letra;
        this.numero = null;
    }


    Alfanumerico(int numero) {
        this.letra = null;
        this.numero = numero;
    }


    public Character getLetra() {
        return letra;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return (letra != null) ? String.valueOf(letra) : String.valueOf(numero);
    }
}

