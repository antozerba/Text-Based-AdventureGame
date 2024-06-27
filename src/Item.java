public enum Item {
    Torcia,
    Macete,
    ChiaveDellAvventuriero,
    ChiaveDellaSerpeSmeraldo,
    PergamenaDelleProfezieAntiche,
    CaliceDelSangueAntico,
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
                return "Chiave Dell Avventuriero";
            }case ChiaveDellaSerpeSmeraldo -> {
                return "Chiave Della Serpe Smeraldo";
            }case PergamenaDelleProfezieAntiche -> {
                return "Pergamena Delle Profezie Antiche";
            }case CaliceDelSangueAntico -> {
                return "Calice Del Sangue Antico";
            }case LanternaDellEternaPenombra -> {
                return "Lanterna Dell Eterna Penombra";
            }case ChiaveDelTesoroAntico -> {
                return "Chiave Del Tesoro Antico";
            }case TesoroAntico -> {
                return "Tesoro Antico";
            }default -> {
                return null;
            }
        }
    }
};
