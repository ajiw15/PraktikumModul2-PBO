package Aji07209_SistemInformasiPendataanKorbanBencana;

import Aji07209_Entity.*;
import Aji07209_Model.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Aji07209_Main {
    private static Scanner input = new Scanner (System.in);
    private static Aji07209_KorbanModel korbanModel = new Aji07209_KorbanModel();
    private static Aji07209_DataKorbanModel datakorbanModel = new Aji07209_DataKorbanModel();
    private static int pilstatus;
    static int cekkorban;
    
     public static void main(String[] args){
        int loop=0;
        do{
           int pilih = 0 ;
           System.out.print("\n Sistem Informasi Korban Bencana" +
                            "\n 1. Daftar Korban Baru" +
                            "\n 2. View Data " +
                            "\n 3. Update Status "+
                            "\n 0. Stop" +
                            "\n Masukkan Pilihan Anda : ");
                        pilih = input.nextInt();
                                if(pilih == 1){
                                  daftar();
                              }else if(pilih == 2){
                              viewdata();
                              }else if(pilih == 3){
                              updatestatus();
                              }else if(pilih == 4){
                              }else{
                                break;
            }
        }while (loop != 1);
     }
        
    static void daftar(){
        System.out.print("Input NIK = ");
        String nik = input.next();
        System.out.print("Input Nama = ");
        String nama = input.next();
        System.out.print("Input Pekerjaan = ");
        String pekerjaan = input.next();
        System.out.print("Input Golongan Darah = ");
        String goldar =  input.next();
        System.out.print("Input Agama = ");
        String agama =  input.next();
        System.out.print("Input Jenis Kelamin = ");
        String jeniskelamin =  input.next();
        System.out.print("Input No Telp = ");
        String notelp =  input.next();
        System.out.print("Input Tgl Lahir (mm/dd/yyyy) = ");
        Date tanggal = new Date(input.next());
        System.out.print("Bantuan = ");
        String bantuan = input.next();
        korbanModel.insert(new Aji07209_KorbanEntity(nik,nama,pekerjaan,goldar,agama,jeniskelamin,notelp,bantuan,tanggal));
    }

    static void viewdata(){
        System.out.print("NIK : ");
        String nik = input.next();
        System.out.print("Nama : ");
        String nama = input.next();
        cekkorban = korbanModel.cekData(nik, nama);
        System.out.println("\n Data Dari "+korbanModel.getkorbanEntityArrayList(cekkorban).getAji07209_nama());
        int cekstatus = datakorbanModel.cekData(nik, nama);
        if (cekstatus == -1){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else if(cekstatus == -2){
            System.out.println("\n Status Anda Belom Di Daftarkan");
                daftarstatus();
        }else{
        System.out.println("Nama = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_nama());
        System.out.println("NIK = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_nik());
        System.out.println("Pekerjaan = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_pekerjaan());
        System.out.println("Golongan Darah = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_goldarah());
        System.out.println("Agama = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_agama());
        System.out.println("Jenis Kelamin = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_jeniskelamin());
        System.out.println("No Telp = "+datakorbanModel.showDataKorban(cekkorban).getKorban().getAji07209_notelp());
        System.out.println("Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").format(datakorbanModel.showDataKorban(cekkorban)
                .getKorban().getAji07209_TglLahir()));
        System.out.println("Status Korban = "+Aji07209_StatusEntity.Aji07209_Status[datakorbanModel.showDataKorban(cekkorban).getIndexStatus()]);
        }
    }
    
    static void daftarstatus(){
        System.out.print("Pilih Status = \n");
        for(int i=0;i<Aji07209_StatusEntity.Aji07209_Status.length;i++){
        System.out.println(i+". "+Aji07209_StatusEntity.Aji07209_Status[i]);
        }
        System.out.print("Pilih Status = ");
            pilstatus = input.nextInt();
            datakorbanModel.insertDataDataKorban(new Aji07209_DataKorbanEntity(pilstatus,
               korbanModel.getkorbanEntityArrayList(cekkorban)));
        }
    
    static void updatestatus(){
        System.out.print("Input NIK = ");
        String nik = input.next();
        datakorbanModel.update(nik);
    }
}
