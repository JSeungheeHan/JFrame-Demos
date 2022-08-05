/*    */ package Snakerer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Timer
/*    */ {
/*    */   int tick;
/*    */   double delay;
/*    */   boolean isTiming = false;
/*    */   
/*    */   public Timer(double delay) {
/* 13 */     this.delay = delay;
/*    */   }
/*    */ 
/*    */   
/*    */   public void start() {
/* 18 */     this.isTiming = true;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 22 */     this.isTiming = false;
/*    */   }
/*    */   
/*    */   public void restart() {
/* 26 */     this.tick = 0;
/* 27 */     start();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean update() {
/* 32 */     if (this.isTiming) {
/*    */       
/* 34 */       if (this.tick >= this.delay * 30.0D) {
/*    */         
/* 36 */         this.tick = 0;
/*    */         
/* 38 */         return true;
/*    */       } 
/*    */ 
/*    */       
/* 42 */       this.tick++;
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\Timer.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */