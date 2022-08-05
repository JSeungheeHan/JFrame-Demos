/*    */ package Snakerer;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ 
/*    */ public class background
/*    */   extends Rectangle
/*    */ {
/* 11 */   Color col = Color.WHITE;
/*    */   public background(int x, int y) {
/* 13 */     super(x, y, 42, 42);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public void draw(Graphics2D win) {
/* 20 */     float first = 0.4F;
/* 21 */     float second = 0.9F;
/* 22 */     float colorize = 0.1F;
/* 23 */     win.setColor(Color.getHSBColor(colorize, first, second));
/* 24 */     win.fill(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\background.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */