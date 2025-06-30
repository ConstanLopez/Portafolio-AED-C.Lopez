package UT1_PD5;

public enum Consonantes {
     B('B'), C('C'), D('D'), F('F'), G('G'), H('H'),  J('J'),
    K('K'), L('L'), M('M'), N('N'), P('P'), Q('Q'), R('R'), S('S'), T('T'),
    V('V'), W('W'), X('X'), Y('Y'), Z('Z');

    private final Character letra;
    Consonantes(char letra) {
        this.letra = letra;
    }
    public Character getLetra() {
        return letra;
    }
}
