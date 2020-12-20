package osi;import org.owasp.esapi.ESAPI;import org.owasp.esapi.codecs.UnixCodec;import org.owasp.esapi.codecs.WindowsCodec;import java.io.IOException;public class OSITest1 {  public void test(String data) throws IOException, InterruptedException {    String osCommand;    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {      /* running on Windows */      osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";    } else {      /* running on non-Windows */      osCommand = "/bin/ls ";    }    /* POTENTIAL FLAW: command injection */    Process process = Runtime.getRuntime().exec(osCommand + encodeForOS(data));    process.waitFor();  }  private String encodeForOS(String param) {    if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0) {      return ESAPI.encoder().encodeForOS(new WindowsCodec(), param);    } else {      return ESAPI.encoder().encodeForOS(new UnixCodec(), param);    }  }}