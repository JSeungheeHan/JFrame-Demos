/*     */ package Utility;
/*     */ 
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.KeyListener;
/*     */ import java.awt.image.BufferStrategy;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.IOException;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JFrame;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GDV5
/*     */   extends Canvas
/*     */   implements Runnable, KeyListener
/*     */ {
/*     */   private int FramesPerSecond;
/*     */   protected static boolean[] KeysPressed;
/*     */   protected static boolean[] KeysTyped;
/*     */   private JFrame frame;
/*  39 */   private String title = "Default";
/*     */   
/*     */   private boolean cleanCanvas = true;
/*     */   
/*     */   public GDV5(int frames) {
/*  44 */     this.FramesPerSecond = frames;
/*     */     
/*  46 */     addKeyListener(this);
/*     */ 
/*     */     
/*  49 */     KeysPressed = new boolean[402];
/*  50 */     KeysTyped = new boolean[402];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GDV5() {
/*  56 */     this(60);
/*     */     
/*  58 */     setBackground(Color.BLACK);
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  63 */     if (getWidth() == 0) {
/*  64 */       setSize(840, 840);
/*     */     }
/*     */     
/*  67 */     this.frame = new JFrame();
/*     */     
/*  69 */     this.frame.add(this);
/*  70 */     this.frame.pack();
/*  71 */     this.frame.setTitle(this.title);
/*  72 */     this.frame.setDefaultCloseOperation(3);
/*  73 */     this.frame.setLocationRelativeTo((Component)null);
/*  74 */     this.frame.setResizable(false);
/*     */     
/*  76 */     this.frame.setVisible(true);
/*     */     
/*  78 */     startThread();
/*     */   }
/*     */ 
/*     */   
/*     */   private synchronized void startThread() {
/*  83 */     Thread t1 = new Thread(this);
/*  84 */     t1.start();
/*  85 */     setFocusable(true);
/*     */   }
/*     */   
/*     */   public void setFrames(int num) {
/*  89 */     this.FramesPerSecond = num;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract void update();
/*     */   
/*     */   public abstract void draw(Graphics2D paramGraphics2D);
/*     */   
/*     */   private void render() {
/*  98 */     BufferStrategy buffs = getBufferStrategy();
/*  99 */     if (buffs == null) {
/* 100 */       createBufferStrategy(3);
/* 101 */       buffs = getBufferStrategy();
/*     */     } 
/*     */     
/* 104 */     Graphics g = buffs.getDrawGraphics();
/*     */     
/* 106 */     if (this.cleanCanvas) {
/* 107 */       g.setColor(getBackground());
/* 108 */       g.fillRect(0, 0, getWidth(), getHeight());
/*     */     } 
/*     */     
/* 111 */     draw((Graphics2D)g);
/*     */     
/* 113 */     g.dispose();
/*     */     
/* 115 */     buffs.show();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/* 121 */     long lastTime = System.nanoTime();
/* 122 */     double nanoSecondConversion = 1.0E9D / this.FramesPerSecond;
/* 123 */     double changeInSeconds = 0.0D;
/*     */     
/*     */     while (true) {
/* 126 */       long now = System.nanoTime();
/*     */       
/* 128 */       changeInSeconds += (now - lastTime) / nanoSecondConversion;
/* 129 */       while (changeInSeconds >= 1.0D) {
/* 130 */         update();
/* 131 */         changeInSeconds--;
/*     */       } 
/*     */       
/* 134 */       render();
/* 135 */       lastTime = now;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BufferedImage addImage(String name) {
/* 141 */     BufferedImage img = null;
/*     */     
/*     */     try {
/* 144 */       img = ImageIO.read(getClass().getResourceAsStream(name));
/*     */     }
/* 146 */     catch (IOException e) {
/* 147 */       System.out.println(e);
/*     */     } 
/*     */     
/* 150 */     return img;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 157 */     KeysPressed[e.getKeyCode()] = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyReleased(KeyEvent e) {
/* 164 */     KeysPressed[e.getKeyCode()] = false;
/* 165 */     KeysTyped[e.getKeyCode()] = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int collisionDirection(Rectangle stationary, Rectangle projectile, int dx, int dy) {
/* 184 */     int previousXPos = (int)projectile.getX() - dx;
/* 185 */     int previousYPos = (int)projectile.getY() - dy;
/* 186 */     int height = (int)projectile.getHeight();
/* 187 */     int width = (int)projectile.getWidth();
/* 188 */     int result = 0;
/*     */     
/* 190 */     if ((previousYPos + height) <= stationary.getY() && projectile.getY() + height >= stationary.getY()) {
/*     */       
/* 192 */       result = 1;
/* 193 */     } else if ((previousXPos + width) <= stationary.getX() && projectile.getX() + width >= stationary.getX()) {
/*     */       
/* 195 */       result = 2;
/* 196 */     } else if (previousYPos >= stationary.getY() + stationary.height && 
/* 197 */       projectile.getY() <= stationary.getY() + stationary.height) {
/*     */       
/* 199 */       result = 3;
/*     */     } 
/*     */     
/* 202 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getTitle() {
/* 207 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/* 211 */     this.title = title;
/*     */   }
/*     */   
/*     */   public void setCleanCanvas(boolean option) {
/* 215 */     this.cleanCanvas = option;
/*     */   }
/*     */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Utility\GDV5.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */