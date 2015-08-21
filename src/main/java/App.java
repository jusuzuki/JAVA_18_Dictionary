import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/newword", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     // Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
     String word = request.queryParams("inputword");
     String definition = request.queryParams("inputdef");
     Word newWord = new Word(word);
     Definition newDef = new Definition(definition);
     String readWord = newWord.getWord();
     model.put("newWord", newWord);
     model.put("newDef", newDef);
     model.put("template", "templates/newword.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


  }
}
