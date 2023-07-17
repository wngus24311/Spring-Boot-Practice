package com.fastcampus.ch1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Calendar;

/**
 * 년 월 일을 입력하면 요일을 알려주는 프로그램
 */
@Controller
public class YoilTeller {

    @RequestMapping(value = "/yoil", method = {RequestMethod.GET, RequestMethod.POST})
//    public String main(Integer year, Integer month, Integer day, Model model) throws IOException {
    public ModelAndView main(Integer year, Integer month, Integer day) throws IOException {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("yoilError");
        if (!isValid(year, month, day)) {
            mv.addObject("year", "잘못된 값입니다.");
            mv.addObject("month", "다른 값을 넣으세요");
            mv.addObject("day", "비상!!!!!");
            mv.addObject("yoil", "쵸비상!!!!!");
            mv.setViewName("yoil"); // yoil.html
            return mv;
        }

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);


        mv.addObject("year", year);
        mv.addObject("month", month);
        mv.addObject("day", day);
        mv.addObject("yoil", yoil);
        mv.setViewName("yoil"); // yoil.html

        return mv;

//        response.setStatus(200);
//        response.setContentType("text/html");
//        response.setCharacterEncoding("utf-8");
//
//        PrintWriter out = response.getWriter();
//
//        out.println("<html>");
//        out.println("<head>요일 계산기~</head>");
//        out.println("<body>Monday hehe");
//        out.println("year = " + year);
//        out.println("month = " + month);
//        out.println("day = " + day);
//        out.println("요일 = " + yoil);
//        out.println("</body>");
//        out.println("</html>");
//        out.close();

//        return out;
    }

    private boolean isValid(Integer year, Integer month, Integer day) {
        if (year <= 0) {
            return false;
        } else if (month <= 0 || 13 <= month) {
            return false;
        } else if (day <= 0 || 32 <= day) {
            return false;
        } else {
            return true;

        }
    }
}
