package FrameWork;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class PrintScreen {
    private static final String CAMINHO_DO_PRINT_SCREEN = System.getProperty("user.dir")
            + File.separator + "relatorio" + File.separator + "Print Screen Foto";

    public static MediaEntityModelProvider fazerCapturaDaFoto(WebDriver driver) throws IOException {
        CreateFolder.criarPastaParaRelatorio(CAMINHO_DO_PRINT_SCREEN);
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String caminho = CAMINHO_DO_PRINT_SCREEN + File.separator + foto.getName();
        FileUtils.copyFile(foto, new File(caminho));
        return MediaEntityBuilder.createScreenCaptureFromPath(caminho).build();

    }

    public static MediaEntityModelProvider fazerCapturaDaFotoBase64(WebDriver driver){
        try {
            CreateFolder.criarPastaParaRelatorio(CAMINHO_DO_PRINT_SCREEN);
            return MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build();
        }catch (IOException e){
            System.out.println(e.getMessage() + "Não gerou screean shot");
        }
        return null;
    }
}
