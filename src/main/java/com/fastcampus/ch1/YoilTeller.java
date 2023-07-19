package com.fastcampus.ch1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

/**
 * 년 월 일을 입력하면 요일을 알려주는 프로그램
 */
@Controller
public class YoilTeller {

    @RequestMapping(value = "/getYoil", method = {RequestMethod.GET, RequestMethod.POST})
    public String main(@ModelAttribute MyDate myDate, Model model) throws IOException {

        char yoil = getYoil(myDate);

        return "yoil";
    }

    @ModelAttribute("yoil")
    private char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);
        return yoil;
    }
}
