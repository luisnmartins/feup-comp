/* Generated By:JJTree: Do not edit this line. ASTArraySize.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTArraySize extends SimpleNode {

  public Boolean nan = false;
  public String sizeVar;
  public Integer size;

  public ASTArraySize(int id) {
    super(id);
  }

  public ASTArraySize(parser p, int id) {
    super(p, id);
  }

  // ArraySize( [variable.size] ) or ArraySize( [variable] ) or ArrraySize( [number] )
  @Override
  public String toString(String prefix) {
    if(nan) {
      return prefix + " "+ toString() + " ( ["+ this.sizeVar +".size] )";
    } else if(this.sizeVar != null) {
      return prefix + " "+ toString() + " ( ["+ this.sizeVar +"] ) ";
    } else {
      return prefix + " "+ toString() + " ( ["+ this.size +"] ) ";
    }    
  } 


}
/* JavaCC - OriginalChecksum=197ebed6e1f42dc9eb62527d2eedd3b8 (do not edit this line) */
