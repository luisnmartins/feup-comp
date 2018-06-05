package parser;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;

/* Generated By:JJTree: Do not edit this line. ASTmodule.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public class ASTModule extends SimpleNode {

  public String name;
  GlobalTable global;

  public ASTModule(int id) {
    super(id);
  }

  public ASTModule(Parser p, int id) {
    super(p, id);
  }

  // Module name
  @Override
  public String toString(String prefix) {
    return prefix + " " + toString() + " " + this.name;
  }

  public SimpleEntry<Boolean, Boolean> tableHandler(GlobalTable parent) {

    global = new GlobalTable();
    global.setModuleName(name);
    Boolean allCorrect = true;
    SimpleEntry<Boolean, Boolean> response;

    if (children == null)
      return new SimpleEntry<>(allCorrect, null);

    Boolean[] tocheck = new Boolean[children.length];

    for (int i = 0; i < children.length; i++) {
      try {
        response = children[i].tableHandler(global);
      } catch (ParseException e) {
        System.out.println(e.getMessage());
        allCorrect = false;
        response = new SimpleEntry<>(false, false);
      }

      tocheck[i] = response.getValue();

    }
    for (int i = 0; i < children.length; i++) {
      if (tocheck[i] != true) {
        try {
          if (children[i].createAndCheckSymbol(global).getKey() == false)
            allCorrect = false;
        } catch (ParseException e) {
          System.out.println(e.getMessage());
          allCorrect = false;
        }

      }

    }

    if (allCorrect) {
      for (int i = 0; i < children.length; i++) {
        children[i].setRegistry(global, 0);
      }
    }

    return new SimpleEntry<>(allCorrect, null);

  }

  public void setYAL2JVM() {
    

    LinkedHashMap<String, String> statics_array_sizes = new LinkedHashMap<>();
    ArrayList instructions = new ArrayList();
    ArrayList staticInitials = new ArrayList();
    instructions.add(".class public " + name);
    instructions.add(".super java/lang/Object");
    instructions.add("");

    staticInitials.add(".method static public <clinit>()V");

    ArrayList<LinkedHashMap<String, ArrayList>> insts = new ArrayList<LinkedHashMap<String, ArrayList>>();
    LinkedHashMap<String, ArrayList> decs = new LinkedHashMap<>();
    decs.put("declarations", instructions);
    LinkedHashMap<String, ArrayList> statics = new LinkedHashMap<>();
    statics.put("initial", staticInitials);
    LinkedHashMap<String, ArrayList> functionInsts = new LinkedHashMap<>();
    LinkedHashMap<String, ArrayList> countersMap = new LinkedHashMap<>();
    ArrayList counters = new ArrayList<>();
    counters.add(0);
    counters.add(0);
    countersMap.put("counters", counters);

    ArrayList staList = new ArrayList<>();

    insts.add(decs);
    insts.add(statics);
    insts.add(functionInsts);
    insts.add(countersMap);

    Boolean initFunc = false;

    for (int i = 0; i < children.length; i++) {
      if(children[i] instanceof ASTFunction && !initFunc){
        initFunc = true;
        statics.get("initial").add(".limit stack " + insts.get(3).get("counters").get(1));
        statics.get("initial").add(".limit locals " + insts.get(3).get("counters").get(0));
        statics.get("initial").add("");

        staList.add("return");
        staList.add(".end method");
        staList.add("");

        statics.put("finish", staList);

        Path file = Paths.get("Compiled Files/" + global.getModuleName() + ".j");
        ArrayList lines = new ArrayList<>();
        File directory = new File("Compiled Files");
        if (!directory.exists()) {
          directory.mkdir();
        }
        for (String key : insts.get(0).keySet()) {
          ArrayList lis = insts.get(0).get(key);
          for (int j = 0; j < lis.size(); j++) {
            lines.add(lis.get(j).toString());
          }
        }

        try {
          Files.write(file, lines, Charset.forName("UTF-8"));
        } catch (Exception e) {
          // TODO: handle exception
        }

      }
      insts = children[i].getJVMCode(global, insts, statics_array_sizes);
    }
   

    for (String key : insts.get(1).keySet()) {
      ArrayList lis = insts.get(1).get(key);
      for (int i = 0; i < lis.size(); i++) {
        writeToFile(lis.get(i).toString(), name);
      }
    }



  }

  public void print() {
    System.out.println("\n\nSymbol Tables\n");
    global.showAll();
  }
  
}
/*
 * JavaCC - OriginalChecksum=b6e10a4bb8f72b832188d726d14c0ab0 (do not edit this
 * line)
 */