package Domain;

public class Pessoa {
    private String RG;
    private String nome;
    private String sobrenome;
    private Integer idade;
    private String celular;
    private String numEmergencia;
    private String tipoSanguineo;

    public static class Builder{
        private String RG;
        private String nome;
        private String sobrenome;
        private Integer idade;
        private String celular;
        private String numEmergencia;
        private String tipoSanguineo;

        public Builder(){
        }

        public Builder setNome(String nome){ this.nome = nome; return this; }

        public Builder setRG(String RG){ this.RG = RG; return this; }

        public Builder setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public Builder setIdade(Integer idade) {
            this.idade = idade;
            return this;
        }

        public Builder setCelular(String celular) {
            this.celular = celular;
            return this;
        }

        public Builder setNumEmergencia(String numEmergencia) {
            this.numEmergencia = numEmergencia;
            return this;
        }

        public Builder setTipoSanguineo(String tipoSanguineo) {
            this.tipoSanguineo = tipoSanguineo;
            return this;
        }

        public Pessoa build(){
            return new Pessoa(this);
        }
    }

    private Pessoa(Builder builder){
        nome = builder.nome;
        RG = builder.RG;
        sobrenome = builder.sobrenome;
        idade = builder.idade;
        celular = builder.celular;
        numEmergencia = builder.numEmergencia;
        tipoSanguineo = builder.tipoSanguineo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Domain.Pessoa{" +
                "RG='" + RG + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", idade=" + idade +
                ", celular='" + celular + '\'' +
                ", numEmergencia='" + numEmergencia + '\'' +
                ", tipoSanguineo='" + tipoSanguineo + '\'' +
                '}';
    }
}
