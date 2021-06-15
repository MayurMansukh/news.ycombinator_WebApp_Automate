/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : mayur mansukh
 * Date        : 12/06/2021
 */

package com.bridgelabz;

import com.bridgelabz.Pages.NewsHandings_Print;
import com.bridgelabz.base.Base;
import org.testng.annotations.Test;

public class most_popular_news_headings extends Base {
    public NewsHandings_Print Print;

    @Test
    public void news_print(){
        Print = new NewsHandings_Print(driver);
        Print.list_Of_all_News();
        System.out.println();
        Print.find_Maximum_Words();
        System.out.println("\n");
        Print.find_maximum_Point_Lines();
    }
}
