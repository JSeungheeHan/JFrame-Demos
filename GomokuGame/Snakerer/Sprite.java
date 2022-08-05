/*    */ package Snakerer;
/*    */ 
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.image.BufferedImage;
/*    */ 
/*    */ public class Sprite
/*    */   implements GameObject {
/*    */   BufferedImage[] sprites;
/*  9 */   int position = 0;
/* 10 */   int positionx = 0;
/* 11 */   int positiony = 0;
/*    */   
/*    */   Timer time;
/*    */   
/*    */   public Sprite(BufferedImage cheet, int rows, int cols, double delay) {
/* 16 */     this.time = new Timer(delay);
/* 17 */     this.time.start();
/* 18 */     this.sprites = new BufferedImage[rows * cols];
/*    */     
/* 20 */     int width = cheet.getWidth() / cols;
/* 21 */     int height = cheet.getHeight() / rows;
/*    */     
/* 23 */     int count = 0;
/*    */     
/* 25 */     for (int i = 0; i < rows; i++) {
/*    */       
/* 27 */       for (int j = 0; j < cols; j++) {
/*    */         
/* 29 */         BufferedImage subImage = cheet.getSubimage(j * width, i * height, width, height);
/* 30 */         this.sprites[count] = subImage;
/* 31 */         count++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void update() {
/* 47 */     if (this.time.update()) {
/* 48 */       this.position++;
/* 49 */       this.position %= this.sprites.length;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void draw(Graphics2D paint) {
/* 57 */     paint.drawImage(this.sprites[this.position], null, this.positionx, this.positiony);
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\Sprite.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */