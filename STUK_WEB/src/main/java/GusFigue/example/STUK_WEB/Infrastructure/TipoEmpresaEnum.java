package GusFigue.example.STUK_WEB.Infrastructure;

public enum TipoEmpresaEnum {

    CD("Centro de distribuição"),
    LF("Loja física"),
    EC("E-commerce"),
    PD("Posto de devolução");

    private final String Tipos;

    TipoEmpresaEnum(String Tipos) {
        this.Tipos = Tipos;
    }

    public String getTipos() {
        return Tipos;
    }
}
