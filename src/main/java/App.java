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

      return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

    post("/addword", (request, response) -> {
     HashMap<String, Object> model = new HashMap<String, Object>();
     ArrayList<Word> words = request.session().attribute("words");

     if (words == null) {
       words = new ArrayList<Word>();
       request.session().attribute("words", words);
     }

     String word = request.queryParams("inputword");
     Word newWord = new Word(word);
     words.add(newWord);

     model.put("word", word);
     model.put("template", "templates/addword.vtl");
     return new ModelAndView(model, layout);
   }, new VelocityTemplateEngine());

   get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("word", Word.find(Integer.parseInt(request.params(":id"))));
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.queryParams("wordId")));
      String definition = request.queryParams("definition");
      Definition newDef = new Definition(definition);
      word.addDefinition(newDef);
      model.put("word", word);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
