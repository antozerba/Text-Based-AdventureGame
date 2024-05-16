public enum Item {
    Torcia,
    Macete,
    ChiaveDellAvventuriero,
    ChiaveDellaSerpeSmeraldo,
    PergamenaDelleProfezieAntiche,
    CaliceDelSangueSanto,
    LanternaDellEternaPenombra,
    ChiaveDelTesoroAntico,
    TesoroAntico;

    @Override
    public String toString(){
        switch(this){
            case Torcia -> {
                return "Torcia";
            }case Macete -> {
                return "Macete";
            }case ChiaveDellAvventuriero -> {
                return "Chiave dell'Avventuriero";
            }case ChiaveDellaSerpeSmeraldo -> {
                return "Chiave della Serpe Smeraldo";
            }case PergamenaDelleProfezieAntiche -> {
                return "Pergamena delle Profezie Antiche";
            }case CaliceDelSangueSanto -> {
                return "Calice del Sangue Antico";
            }case LanternaDellEternaPenombra -> {
                return "Lanterna dell'Eterna Penombra";
            }case ChiaveDelTesoroAntico -> {
                return "Chiave del Tesoro Antico";
            }case TesoroAntico -> {
                return "Tesoro Antico";
            }default -> {
                return null;
            }
        }
    }
};
