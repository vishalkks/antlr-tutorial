package edu.ucsd.cse232b.antlrTutorial.listener;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import edu.ucsd.cse232b.parsers.ExpressionGrammarLexer;
import edu.ucsd.cse232b.parsers.ExpressionGrammarParser;
import edu.ucsd.cse232b.antlrTutorial.expression.Prog;

public class main {
     public static void main(String[] args) {
         final String expression = "(A+B)*C";
         final ExpressionGrammarLexer lexer = new ExpressionGrammarLexer(CharStreams.fromString(expression));
         final CommonTokenStream tokens = new CommonTokenStream(lexer);
         final ExpressionGrammarParser parser = new ExpressionGrammarParser(tokens);
         final ParserRuleContext tree = parser.prog();
         final ParseTreeWalker walker = new ParseTreeWalker();
         final ExpressionBuilder expressionBuilder = new ExpressionBuilder();
         walker.walk(expressionBuilder, tree);

         final Prog expressionObject = expressionBuilder.getProg(tree);
         System.out.println(expressionObject.toString());

    }
}
