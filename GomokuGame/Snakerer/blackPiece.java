/*    */ package Snakerer;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class blackPiece
/*    */ {
/* 11 */   Color col = Color.WHITE;
/* 12 */   int x = -10;
/* 13 */   int y = -10;
/*    */   public blackPiece(int a, int b) {
/* 15 */     this.x = a;
/* 16 */     this.y = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public void draw(Graphics2D win) {
/* 23 */     win.setColor(Color.BLACK);
/* 24 */     win.fillOval(this.x - 18, this.y - 18, 36, 36);
/* 25 */     win.setColor(Color.white);
/* 26 */     win.drawOval(this.x - 18, this.y - 18, 36, 36);
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\blackPiece.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */