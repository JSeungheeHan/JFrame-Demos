/*    */ package Snakerer;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.Rectangle;
/*    */ 
/*    */ 
/*    */ public class tile
/*    */   extends Rectangle
/*    */ {
/* 11 */   Color col = Color.WHITE;
/*    */   public tile(int x, int y) {
/* 13 */     super(x + 42, y + 42, 42, 42);
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public void draw(Graphics2D win) {
/* 20 */     win.setColor(Color.BLACK);
/* 21 */     win.draw(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\tile.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */