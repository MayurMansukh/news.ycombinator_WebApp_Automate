/**
 * Description : News_Heading.java is test file which is having test cases for News_Heading.
 * Author      : mayur mansukh
 * Date        : 12/06/2021
 */

package com.bridgelabz.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;

public class NewsHandings_Print {
    public static LinkedList<String> headlines = new LinkedList<>();
    public static LinkedList<Integer> points = new LinkedList<>();
    public static HashMap<String, Integer> Hashmap = new HashMap<>();
    public static HashMap<String, Integer> Hashmap2 = new HashMap<>();

    @FindBy(xpath = "//a[text() = 'More']")
    WebElement More;

    @FindBy(xpath = "//a[@class = 'storylink']")
    List<WebElement> Title;

    @FindBy(xpath = "//span[@class = 'score']")
    List<WebElement> Points;

    public NewsHandings_Print(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void list_Of_all_News() {
        int count = 30;
        while (count <= 121) {
            Iterator<WebElement> titleIterator = Title.iterator();
            while (titleIterator.hasNext()) {
                String news = titleIterator.next().getText();
                headlines.add(news);
            }
            Iterator<WebElement> pointIterator = Points.iterator();
            while (pointIterator.hasNext()) {
                String news = pointIterator.next().getText();
                String Itr = getString(news);
                int intValue = getStringValue(Itr);
                points.add(intValue);
            }
            More.click();
            count += 30;
        }
        for (int i = 0; i < points.size(); i++) {
                Hashmap.put(headlines.get(i), points.get(i));
        }
        for (Map.Entry<String, Integer> entry : Hashmap.entrySet()) {
            System.out.println("Headline :" + entry.getKey() + " Points :" + entry.getValue());
        }
    }

    public static int getStringValue(String Itr) {

        return Integer.parseInt(Itr);
    }

    public static String getString(String Itr) {
        Itr = Itr.replaceAll("[^\\d]", " ");
        Itr = Itr.trim();
        Itr = Itr.replaceAll(" +", " ");
        return Itr;
    }

    public static String[] getArray(String Itr) {
        String ItrArray[] = Itr.split(" ");
        return ItrArray;
    }

    public String find_Maximum_Words() {
        String Itr = null;
        for (int i = 0; i < headlines.size(); i++) {
            String ItrArray[] = getArray(headlines.get(i));
            for (int j = 0; j < ItrArray.length; j++) {
                if (Hashmap2.get(ItrArray[j]) == null) {
                    Hashmap2.put(ItrArray[j], 1);
                } else {
                    Hashmap2.put(ItrArray[j], Hashmap2.get(ItrArray[j]) + 1);
                }
            }
        }
        Integer[] intArray = Hashmap2.values().toArray(new Integer[0]);
        Arrays.sort(intArray);
        int max = intArray[intArray.length - 1];
        for (Map.Entry<String, Integer> entry : Hashmap2.entrySet()) {
            if (entry.getValue().equals(max)) {
                Itr = entry.getKey();
                System.out.println("Maximum occured word is :" + entry.getKey() + " and value is : " + entry.getValue());
            }
        }
        return Itr;
    }

    public void find_maximum_Point_Lines() {
        Integer[] intArray = Hashmap.values().toArray(new Integer[0]);
        Arrays.sort(intArray);
        int max = intArray[intArray.length - 1];
        for (Map.Entry<String, Integer> entry : Hashmap.entrySet()) {
            if (entry.getValue().equals(max)){
                System.out.println("News with maximum points :" +entry.getKey() + "and points are :" +entry.getValue());
            }
        }
    }
}
