package util;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.bean.Songs;

public class AuthUtil {
	
	public static boolean checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		if (session.getAttribute("userLogin") == null) {
			return false;
		}
		return true;
	}
	public static boolean isName(String val) {
		String name = "^[A-ZÁÀÃẢẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒÕỎỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴa-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ0-9 ]*$";
		if (val.matches(name)) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean checkNameSong(ArrayList<Songs> list, String name) {
		for (Songs songs : list) {
			if(songs.getSongName().equalsIgnoreCase(name)) {
				return false;
			}
		}		
		return true;
	}
}
