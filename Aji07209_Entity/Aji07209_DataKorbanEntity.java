package Aji07209_Entity;



public class Aji07209_DataKorbanEntity {
    private Aji07209_KorbanEntity korban;
    private int indexStatus; 

    public Aji07209_DataKorbanEntity(int indexStatus, Aji07209_KorbanEntity korban) {
        this.indexStatus = indexStatus;
        this.korban = korban;
    }

      public Aji07209_KorbanEntity getKorban() {
        return korban;
    }

    public void setKorban(Aji07209_KorbanEntity korban) {
        this.korban = korban;
    }

    public int getIndexStatus() {
        return indexStatus;
    }

    public void setIndexStatus(int indexStatus) {
        this.indexStatus = indexStatus;
    }
        
}
