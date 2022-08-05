/*    */ package Snakerer;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class whitePiece
/*    */ {
/* 11 */   Color col = Color.WHITE;
/* 12 */   int x = -10;
/* 13 */   int y = -10;
/*    */   public whitePiece(int a, int b) {
/* 15 */     this.x = a;
/* 16 */     this.y = b;
/*    */   }
/*    */ 
/*    */   
/*    */   public void update() {}
/*    */   
/*    */   public void draw(Graphics2D win) {
/* 23 */     win.setColor(Color.WHITE);
/* 24 */     win.fillOval(this.x - 18, this.y - 18, 36, 36);
/* 25 */     win.setColor(Color.black);
/* 26 */     win.drawOval(this.x - 18, this.y - 18, 36, 36);
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\whitePiece.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */