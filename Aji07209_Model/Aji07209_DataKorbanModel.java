package Aji07209_Model;

import Aji07209_Entity.Aji07209_DataKorbanEntity;
import Aji07209_Entity.Aji07209_StatusEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Aji07209_DataKorbanModel implements Aji07209_ModelInterfaces {
    private static Scanner input = new Scanner (System.in);
    private ArrayList<Aji07209_DataKorbanEntity> datakorbanArrayList;
    
    public Aji07209_DataKorbanModel(){
    datakorbanArrayList = new ArrayList<Aji07209_DataKorbanEntity>();
        }
    public void insertDataDataKorban(Aji07209_DataKorbanEntity datakorban){
        datakorbanArrayList.add(datakorban);
    }
    public ArrayList<Aji07209_DataKorbanEntity> getdatakorbanArrayList(){
        return datakorbanArrayList;
    }
    
    @Override
 public void view(){
        for(Aji07209_DataKorbanEntity datakorban : datakorbanArrayList){
        System.out.println("===========================================");
        System.out.println(" NIK : "+datakorban.getKorban().getAji07209_nik()+"\n Nama : "
         +datakorban.getKorban().getAji07209_nama()+"\n Pekerjaan : "+datakorban.getKorban().getAji07209_pekerjaan()+
            "\n Golongan Darah : "+datakorban.getKorban().getAji07209_goldarah()+
            "\n Agama : "+datakorban.getKorban().getAji07209_agama()+"\n Jenis Kelamin : "
            +datakorban.getKorban().getAji07209_jeniskelamin()+"\n No Telp : "
            +datakorban.getKorban().getAji07209_notelp()+"\n Tanggal Lahir : "
            +new SimpleDateFormat("dd-MM-yyyy").format(datakorban.getKorban().getAji07209_TglLahir())+
            "\n Status : "+Aji07209_StatusEntity.Aji07209_Status[datakorban.getIndexStatus()]);
        }   
    }
  public int cekData(String nik, String nama){
        int loop = 0;
        if(datakorbanArrayList.size() ==0){
            loop = -1;
        }else{
            for(int i = 0; i <datakorbanArrayList.size(); i++){
            if(datakorbanArrayList.get(i).getKorban().getAji07209_nik().equals(nik)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
  
    public Aji07209_DataKorbanEntity showDataKorban(int index){
        return datakorbanArrayList.get(index);
    }   
    
    private int carinik(String Aji07209_nik){
        int index=-1;
        for(int i=0;i <datakorbanArrayList.size();i++) {
           if(Aji07209_nik.equals(datakorbanArrayList.get(i).getKorban().getAji07209_nik()))
               index=i;
       }
       return index;
    }
        public void update(String Aji07209_nik){
        if(carinik(Aji07209_nik)!=-1){
             for(int i=0;i<Aji07209_StatusEntity.Aji07209_Status.length;i++){
                        System.out.println(i+". "+Aji07209_StatusEntity.Aji07209_Status[i]);
                    }
            System.out.print("Update Status = ");
            int statusbaru=input.nextInt();
            datakorbanArrayList.get(carinik(Aji07209_nik)).setIndexStatus(statusbaru);
        }
        else {
            System.out.println("Data tidak Ditemukan");
        }
    }
}
