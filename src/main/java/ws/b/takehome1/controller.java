/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws.b.takehome1;

import java.io.IOException;
import java.sql.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mwllf
 */
@Controller
public class controller {
        @RequestMapping(value="/insertdata", method=RequestMethod.POST)
        public String getInsert(@RequestParam(value="nama") String insertnama,
                                @RequestParam(value="tanggal") Date inserttanggal,
                                @RequestParam(value="foto") MultipartFile insertfoto,
                                Model model)throws IOException{
            
            byte[] inputimg = insertfoto.getBytes();
            String base64Image = Base64.encodeBase64String(inputimg);
            String linkfoto = "data:image/png;base64,".concat(base64Image);
            
            String getDate = "" + inserttanggal;
            
            model.addAttribute("nama", insertnama);
            model.addAttribute("tanggal", getDate);
            model.addAttribute("foto", linkfoto);
            return "main";
           
            
        }
    
}
