/* Generated By:JJTree: Do not edit this line. ASTElement.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package parser;
public
class ASTElement extends SimpleNode {

  public Boolean isArray = false;
  public String name;

  public ASTElement(int id) {
    super(id);
  }

  public ASTElement(Parser p, int id) {
    super(p, id);
  }

  //Element(id[]) or Element(id)
  @Override
  public String toString(String prefix) { 
    if(this.isArray)
      return prefix + " " + toString() + " ( " +this.name + "[] )"; 
    else
      return prefix + " " + toString() + " ( " +this.name + " )";  
  }

}
/* JavaCC - OriginalChecksum=f6a99221fb90699f26b3fa37c06aebac (do not edit this line) */
