// Generated from Compound.g4 by ANTLR 4.3

 package quimica.ufc.br.estequiometria.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CompoundParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CompoundVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CompoundParser#parens}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(CompoundParser.ParensContext ctx);

	/**
	 * Visit a parse tree produced by {@link CompoundParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(CompoundParser.SContext ctx);

	/**
	 * Visit a parse tree produced by {@link CompoundParser#compound}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound(CompoundParser.CompoundContext ctx);

	/**
	 * Visit a parse tree produced by {@link CompoundParser#hidr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHidr(CompoundParser.HidrContext ctx);

	/**
	 * Visit a parse tree produced by {@link CompoundParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(CompoundParser.ElementContext ctx);
}