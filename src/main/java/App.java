import java.util.Arrays;
import java.util.ArrayList;
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

      model.put("words", request.session().attribute("words"));
      model.put("definitions", request.session().attribute("definitions"));

      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    post("/newword", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     ArrayList<Word> words = request.session().attribute("words");
     ArrayList<Definition> definitions = request.session().attribute("definitions");

     if (words == null) {
       words = new ArrayList<Word>();
       request.session().attribute("words", words);
     }

     if (definitions == null) {
       definitions = new ArrayList<Definition>();
       request.session().attribute("definitions", definitions);
     }

     String word = request.queryParams("inputword");
     Word newWord = new Word(word);
     words.add(newWord);

     String definition = request.queryParams("inputdef");
     Definition newDef = new Definition(definition);
     definitions.add(newDef);

     model.put("template", "templates/newword.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());


  }
}
