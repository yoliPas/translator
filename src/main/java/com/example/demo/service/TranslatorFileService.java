package com.example.demo.service;

import org.springframework.util.StreamUtils;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TranslatorFileService {
    private ArrayList<String>estrofas;
    private ArrayList<String>estrofasInvertidas;

    public TranslatorFileService() {
        estrofas=new ArrayList<String>();
        estrofasInvertidas=new ArrayList<String>();
    }

   /*public String readFile(){
        try{
            FileReader file = new FileReader("C:\\Users\\HP\\Desktop\\original.txt");
            int res = file.read();
            while (res!=-1){
                res = file.read();
                char letra = (char)res;
                System.out.print(letra);
            }
        }catch (IOException e){
            System.out.println("Not found file in the direction specified");

        }
        return null;
    }
        public String readInvest() throws IOException {
            String inputFileName = "C:\\Users\\HP\\Desktop\\original.txt";
            InputStream in = new FileInputStream(inputFileName);
            String texto= " ";

            int c=in.read();
            while(c!=-1) {
                c = in.read();
                //out.write(c);
                //System.out.println(c);
                char letra = (char)c;
                texto+=letra;

            }
            in.close();
            return texto;
        }


        public void fileOverturn() throws IOException{
            String txt = readInvest();
            String sCadenaInvertida = " ";
            for (int x=txt.length()-1;x>=0;x--) {
                sCadenaInvertida = sCadenaInvertida + txt.charAt(x);
            }
            System.out.println(sCadenaInvertida);
        }
    */

        public boolean esInvertido() throws IOException {
            String inputFileName = "C:\\Users\\HP\\Desktop\\original.txt";
            String outputFileName = "C:\\Users\\HP\\Desktop\\estrofasEnOrdenInverso.txt";
            File outputFile = new File(outputFileName);
            OutputStream out = new FileOutputStream(outputFileName);
            recorrerLineas(inputFileName);
            invertirEstrofas();
            String invertString = toString(estrofasInvertidas);
            StreamUtils.copy(invertString, StandardCharsets.UTF_8, out);
            return  outputFile.exists();
        }

        public String toString(ArrayList<String> list){
            String cadena = " ";
            for (String line : list) {
                if(line.equals("VACIO")){
                    cadena+="\n";
                }else{
                    cadena+=line+"\n";
                }
            }
            return cadena;
        }

        public void invertirEstrofas(){
            ArrayList<String> listAux = new ArrayList<String>();

            for (int i = estrofas.size()-1; i>=0 ; i--){
                if(estrofas.get(i).equals("VACIO")){
                    for (int j = listAux.size()-1; j>=0; j--){
                        estrofasInvertidas.add(listAux.get(j));
                    }
                    estrofasInvertidas.add("VACIO");
                    listAux.clear();
                }else{
                    listAux.add(estrofas.get(i));
                }
            }
            if(listAux.size()>0){
                for (int j = listAux.size()-1 ; j>=0 ; j--){
                    estrofasInvertidas.add(listAux.get(j));
                }
                listAux.clear();
            }
        }

        public void recorrerLineas(String rutaDelArchivo) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(rutaDelArchivo));
                String linea = br.readLine();
                estrofas.add(linea);
                while(linea != null)
                {
                    linea = br.readLine();
                    if(!linea.equals("")){
                        estrofas.add(linea);
                    }
                    else{
                       estrofas.add("VACIO");
                    }
                }
            }
            catch(Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                try {
                    if(br != null)
                        br.close();
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
