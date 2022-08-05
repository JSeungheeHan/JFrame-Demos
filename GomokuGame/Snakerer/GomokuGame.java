/*     */ package Snakerer;
/*     */ 
/*     */ import Utility.GDV5;
/*     */ import Utility.SoundDriverHo;
/*     */ import java.awt.Canvas;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics2D;
/*     */ 
/*     */ public class GomokuGame
/*     */   extends GDV5
/*     */ {
/*  13 */   int player = 0;
/*     */   boolean ingame = false;
/*  15 */   tile[][] board = new tile[18][18];
/*  16 */   whitePiece[][] wpieces = new whitePiece[30][30];
/*  17 */   blackPiece[][] bpieces = new blackPiece[30][30];
/*  18 */   background[][] back = new background[24][24];
/*     */   
/*     */   static SoundDriverHo song;
/*     */   boolean won = false;
/*     */   
/*     */   public GomokuGame() {
/*  24 */     String[] audio = new String[2];
/*  25 */     audio[0] = "Lala.wav";
/*  26 */     audio[1] = "Ticker.wav";
/*  27 */     song = new SoundDriverHo(audio, (Canvas)this); int i;
/*  28 */     for (i = 0; i < 18; i++) {
/*     */       
/*  30 */       for (int b = 0; b < 18; b++)
/*     */       {
/*  32 */         this.board[i][b] = new tile(i * 42, b * 42);
/*     */       }
/*     */     } 
/*  35 */     for (i = 0; i < 24; i++) {
/*     */       
/*  37 */       for (int b = 0; b < 24; b++)
/*     */       {
/*  39 */         this.back[i][b] = new background(i * 42, b * 42); } 
/*     */     } 
/*     */   }
/*     */   boolean black = true; boolean ispressed = false;
/*     */   
/*     */   public static void main(String[] args) {
/*  45 */     GomokuGame f1 = new GomokuGame();
/*  46 */     f1.setTitle("Gomoku");
/*  47 */     f1.start();
/*     */   }
/*     */   
/*     */   public void update() {
/*  51 */     if (this.player == 2 && !song.isPlaying(0) && !this.won)
/*     */     {
/*  53 */       song.play(0);
/*     */     }
/*  55 */     if (this.player != 2)
/*     */     {
/*  57 */       song.stop(0);
/*     */     }
/*  59 */     if (this.player == 2) {
/*     */       
/*  61 */       if (GDV5.KeysPressed[10] && !this.ispressed) {
/*     */         
/*  63 */         int holdx = (getMousePosition()).x / 21;
/*  64 */         int holdy = (getMousePosition()).y / 21;
/*  65 */         holdx *= 21;
/*  66 */         holdy *= 21;
/*  67 */         if (holdx % 42 != 0)
/*     */         {
/*  69 */           holdx += 21;
/*     */         }
/*  71 */         if (holdy % 42 != 0)
/*     */         {
/*  73 */           holdy += 21;
/*     */         }
/*  75 */         if (holdx == 0)
/*     */         {
/*  77 */           holdx = 42;
/*     */         }
/*  79 */         if (holdy == 0)
/*     */         {
/*  81 */           holdy = 42;
/*     */         }
/*  83 */         if (holdx > 798)
/*     */         {
/*  85 */           holdx = 798;
/*     */         }
/*  87 */         if (holdy > 798)
/*     */         {
/*  89 */           holdy = 798;
/*     */         }
/*  91 */         boolean valid = true;
/*  92 */         for (int x = 0; x < this.bpieces.length; x++) {
/*     */           
/*  94 */           for (int y = 0; y < (this.bpieces[0]).length; y++) {
/*     */             
/*  96 */             if (this.bpieces[x][y] != null)
/*     */             {
/*  98 */               if ((this.bpieces[x][y]).x == holdx && (this.bpieces[x][y]).y == holdy)
/*     */               {
/* 100 */                 valid = false;
/*     */               }
/*     */             }
/* 103 */             if (this.wpieces[x][y] != null)
/*     */             {
/* 105 */               if ((this.wpieces[x][y]).x == holdx && (this.wpieces[x][y]).y == holdy)
/*     */               {
/* 107 */                 valid = false;
/*     */               }
/*     */             }
/*     */           } 
/*     */         } 
/* 112 */         if (valid)
/*     */         {
/* 114 */           if (this.black) {
/*     */             
/* 116 */             this.bpieces[holdx / 42][holdy / 42] = new blackPiece(holdx, holdy);
/* 117 */             this.black = false;
/* 118 */             song.play(1);
/*     */           }
/*     */           else {
/*     */             
/* 122 */             this.wpieces[holdx / 42][holdy / 42] = new whitePiece(holdx, holdy);
/* 123 */             this.black = true;
/* 124 */             song.play(1);
/*     */           } 
/*     */         }
/* 127 */         this.ispressed = true;
/*     */       } 
/* 129 */       if (!GDV5.KeysPressed[10])
/*     */       {
/* 131 */         this.ispressed = false;
/*     */       }
/*     */     } 
/* 134 */     int inarow = 0; int i;
/* 135 */     for (i = 0; i < 30; i++) {
/*     */       
/* 137 */       for (int b = 0; b < 30; b++) {
/*     */         
/* 139 */         if (this.bpieces[i][b] != null) {
/*     */           
/* 141 */           inarow = 1;
/* 142 */           int iteration = 1;
/* 143 */           while (this.bpieces[i + iteration][b] != null) {
/*     */             
/* 145 */             inarow++;
/* 146 */             iteration++;
/*     */           } 
/* 148 */           if (inarow >= 5) {
/*     */             
/* 150 */             this.won = true;
/* 151 */             this.player = 6;
/*     */           } 
/* 153 */           inarow = 1;
/* 154 */           iteration = 1;
/* 155 */           while (this.bpieces[i][b + iteration] != null) {
/*     */             
/* 157 */             inarow++;
/* 158 */             iteration++;
/*     */           } 
/* 160 */           if (inarow >= 5) {
/*     */             
/* 162 */             this.won = true;
/* 163 */             this.player = 6;
/*     */           } 
/* 165 */           inarow = 1;
/* 166 */           iteration = 1;
/* 167 */           while (this.bpieces[i + iteration][b + iteration] != null) {
/*     */             
/* 169 */             inarow++;
/* 170 */             iteration++;
/*     */           } 
/* 172 */           if (inarow >= 5) {
/*     */             
/* 174 */             this.won = true;
/* 175 */             this.player = 6;
/*     */           } 
/* 177 */           inarow = 1;
/* 178 */           iteration = 1;
/* 179 */           while (this.bpieces[i + iteration][b - iteration] != null) {
/*     */             
/* 181 */             inarow++;
/* 182 */             iteration++;
/*     */           } 
/* 184 */           if (inarow >= 5) {
/*     */             
/* 186 */             this.won = true;
/* 187 */             this.player = 6;
/*     */           } 
/*     */         } 
/* 190 */         inarow = 0;
/*     */       } 
/*     */     } 
/* 193 */     for (i = 0; i < 30; i++) {
/*     */       
/* 195 */       for (int b = 0; b < 30; b++) {
/*     */         
/* 197 */         if (this.wpieces[i][b] != null) {
/*     */           
/* 199 */           inarow = 1;
/* 200 */           int iteration = 1;
/* 201 */           while (this.wpieces[i + iteration][b] != null) {
/*     */             
/* 203 */             inarow++;
/* 204 */             iteration++;
/*     */           } 
/* 206 */           if (inarow >= 5) {
/*     */             
/* 208 */             this.won = true;
/* 209 */             this.player = 5;
/*     */           } 
/* 211 */           inarow = 1;
/* 212 */           iteration = 1;
/* 213 */           while (this.wpieces[i][b + iteration] != null) {
/*     */             
/* 215 */             inarow++;
/* 216 */             iteration++;
/*     */           } 
/* 218 */           if (inarow >= 5) {
/*     */             
/* 220 */             this.won = true;
/* 221 */             this.player = 5;
/*     */           } 
/* 223 */           inarow = 1;
/* 224 */           iteration = 1;
/* 225 */           while (this.wpieces[i + iteration][b + iteration] != null) {
/*     */             
/* 227 */             inarow++;
/* 228 */             iteration++;
/*     */           } 
/* 230 */           if (inarow >= 5) {
/*     */             
/* 232 */             this.won = true;
/* 233 */             this.player = 5;
/*     */           } 
/* 235 */           inarow = 1;
/* 236 */           iteration = 1;
/* 237 */           while (this.wpieces[i + iteration][b - iteration] != null) {
/*     */             
/* 239 */             inarow++;
/* 240 */             iteration++;
/*     */           } 
/* 242 */           if (inarow >= 5) {
/*     */             
/* 244 */             this.won = true;
/* 245 */             this.player = 5;
/*     */           } 
/*     */         } 
/* 248 */         inarow = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Graphics2D win) {
/* 254 */     if (this.player == 0) {
/*     */       
/* 256 */       win.setColor(Color.WHITE);
/* 257 */       win.setFont(new Font("TimesRoman", 1, 84));
/* 258 */       win.drawString("Gomoku", 120, 240);
/* 259 */       win.setFont(new Font("TimesRoman", 1, 32));
/* 260 */       win.drawString("Press 1 to Play", 220, 320);
/* 261 */       win.drawString("Press 2 for Controls", 220, 380);
/* 262 */       win.drawString("Jeffrey Han", 220, 480);
/*     */     } 
/* 264 */     if (GDV5.KeysPressed[50] || this.player == 1) {
/*     */       
/* 266 */       win.setColor(Color.WHITE);
/* 267 */       win.setFont(new Font("TimesRoman", 1, 32));
/* 268 */       win.drawString("This Game is a Gomoku game! A board game where", 40, 50);
/* 269 */       win.drawString("two players take turns pressing [Enter] on a tile to", 40, 100);
/* 270 */       win.drawString("try and get 5 stones of their color in a row.", 40, 150);
/* 271 */       win.drawString("This might seem simple and easy, but your opponent", 40, 200);
/* 272 */       win.drawString("could block your attacks or set up their own. The", 40, 250);
/* 273 */       win.drawString("stone can be diagonal, vertical, or horizontal.", 40, 300);
/* 274 */       win.drawString("In this version, getting 6 in a row still counts", 40, 350);
/* 275 */       win.drawString("as a win because it feels bad for it not to be.", 40, 400);
/* 276 */       win.setFont(new Font("TimesRoman", 1, 64));
/* 277 */       win.drawString("Have Fun!", 250, 480);
/* 278 */       this.player = 1;
/*     */     } 
/* 280 */     if (this.player == 2 || GDV5.KeysPressed[49]) {
/*     */       int i;
/* 282 */       for (i = 0; i < 24; i++) {
/*     */         
/* 284 */         for (int b = 0; b < 24; b++)
/*     */         {
/* 286 */           this.back[i][b].draw(win);
/*     */         }
/*     */       } 
/* 289 */       win.setColor(Color.WHITE);
/* 290 */       for (i = 0; i < 18; i++) {
/*     */         
/* 292 */         for (int b = 0; b < 18; b++)
/*     */         {
/* 294 */           this.board[i][b].draw(win);
/*     */         }
/*     */       } 
/* 297 */       win.fillOval(162, 162, 10, 10);
/* 298 */       win.fillOval(162, 415, 10, 10);
/* 299 */       win.fillOval(162, 667, 10, 10);
/* 300 */       win.fillOval(415, 162, 10, 10);
/* 301 */       win.fillOval(415, 415, 10, 10);
/* 302 */       win.fillOval(415, 667, 10, 10);
/* 303 */       win.fillOval(667, 162, 10, 10);
/* 304 */       win.fillOval(667, 415, 10, 10);
/* 305 */       win.fillOval(667, 667, 10, 10);
/* 306 */       this.player = 2;
/* 307 */       for (i = 0; i < this.wpieces.length; i++) {
/*     */         
/* 309 */         for (int x = 0; x < (this.bpieces[0]).length; x++) {
/*     */           
/* 311 */           if (this.wpieces[i][x] != null)
/*     */           {
/* 313 */             this.wpieces[i][x].draw(win);
/*     */           }
/*     */         } 
/*     */       } 
/* 317 */       for (i = 0; i < this.bpieces.length; i++) {
/*     */         
/* 319 */         for (int x = 0; x < (this.bpieces[0]).length; x++) {
/*     */           
/* 321 */           if (this.bpieces[i][x] != null)
/*     */           {
/* 323 */             this.bpieces[i][x].draw(win);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 328 */     if (this.player == 5) {
/*     */       
/* 330 */       win.setColor(Color.WHITE);
/* 331 */       win.setFont(new Font("TimesRoman", 1, 128));
/* 332 */       win.drawString("White Wins!", 100, 240);
/* 333 */       win.setFont(new Font("TimesRoman", 1, 32));
/* 334 */       win.drawString("Press Space to play Again", 160, 360);
/* 335 */       win.drawString("Hold 1 to see the board", 160, 420);
/* 336 */       if (GDV5.KeysPressed[32]) {
/*     */         
/* 338 */         for (int i = 0; i < this.bpieces.length; i++) {
/*     */           
/* 340 */           for (int b = 0; b < (this.bpieces[0]).length; b++) {
/*     */             
/* 342 */             this.bpieces[i][b] = null;
/* 343 */             this.wpieces[i][b] = null;
/*     */           } 
/*     */         } 
/* 346 */         this.won = false;
/* 347 */         this.player = 0;
/*     */       } 
/*     */     } 
/* 350 */     if (this.player == 6) {
/*     */       
/* 352 */       win.setColor(Color.WHITE);
/* 353 */       win.setFont(new Font("TimesRoman", 1, 128));
/* 354 */       win.drawString("Black Wins!", 100, 240);
/* 355 */       win.setFont(new Font("TimesRoman", 1, 32));
/* 356 */       win.drawString("Press Space to Play Again", 160, 360);
/* 357 */       win.drawString("Hold 1 to see the board", 160, 420);
/* 358 */       if (GDV5.KeysPressed[32]) {
/*     */         
/* 360 */         for (int i = 0; i < this.bpieces.length; i++) {
/*     */           
/* 362 */           for (int b = 0; b < (this.bpieces[0]).length; b++) {
/*     */             
/* 364 */             this.bpieces[i][b] = null;
/* 365 */             this.wpieces[i][b] = null;
/*     */           } 
/*     */         } 
/* 368 */         this.won = false;
/* 369 */         this.player = 0;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Snakerer\GomokuGame.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */