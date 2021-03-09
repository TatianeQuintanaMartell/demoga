package FrameWork;

import java.io.File;

public class CreateFolder {
       public static void criarPastaParaRelatorio(String caminho){
           File diretorioRelatorio = new File(caminho);
              if (!diretorioRelatorio.exists()){
                  diretorioRelatorio.mkdir();
              }

       }
}
