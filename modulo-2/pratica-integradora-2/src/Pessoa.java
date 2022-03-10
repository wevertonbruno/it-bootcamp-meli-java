public class Pessoa {
    private Integer ID;
    private String RG;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String celular;
    private String numEmergencia;
    private String tipoSanguineo;

    public Integer getID() {
        return ID;
    }

    public Pessoa setID(Integer ID) {
        this.ID = ID;
        return this;
    }

    public String getRG() {
        return RG;
    }

    public Pessoa setRG(String RG) {
        this.RG = RG;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public Pessoa setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
        return this;
    }

    public Integer getIdade() {
        return idade;
    }

    public Pessoa setIdade(Integer idade) {
        this.idade = idade;
        return this;
    }

    public String getCelular() {
        return celular;
    }

    public Pessoa setCelular(String celular) {
        this.celular = celular;
        return this;
    }

    public String getNumEmergencia() {
        return numEmergencia;
    }

    public Pessoa setNumEmergencia(String numEmergencia) {
        this.numEmergencia = numEmergencia;
        return this;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public Pessoa setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
        return this;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "ID=" + ID +
                ", RG='" + RG + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", celular='" + celular + '\'' +
                ", numEmergencia='" + numEmergencia + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                '}';
    }
}
