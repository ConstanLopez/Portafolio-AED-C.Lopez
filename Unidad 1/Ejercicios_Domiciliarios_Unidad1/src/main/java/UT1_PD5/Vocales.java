package UT1_PD5;

public enum Vocales {
    A('A'),E('E'),I('I'),O('0'),U('U');
    private final Character letra;
     Vocales(char letra)
    {
        this.letra=letra;
    }
    public Character getLetra() {
        return letra;
    }
}
