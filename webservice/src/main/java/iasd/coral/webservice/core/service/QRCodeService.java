package iasd.coral.webservice.core.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Base64;

@Service
public class QRCodeService {
    public String generateQRCode(String data) throws Exception {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }

    public String generatePresencaQRCode(Long professorId) throws Exception {
        String data = String.format("PRESENCA:%d:%d", professorId, System.currentTimeMillis());
        return generateQRCode(data);
    }
}
