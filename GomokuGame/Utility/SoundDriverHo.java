/*     */ package Utility;
/*     */ 
/*     */ import java.awt.Canvas;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import javax.sound.sampled.AudioFormat;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.Clip;
/*     */ import javax.sound.sampled.DataLine;
/*     */ import javax.sound.sampled.FloatControl;
/*     */ import javax.sound.sampled.LineUnavailableException;
/*     */ import javax.sound.sampled.UnsupportedAudioFileException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SoundDriverHo
/*     */ {
/*     */   private Clip[] clips;
/*     */   private String[] names;
/*     */   private int[] framePosition;
/*     */   private FloatControl[] gainControl;
/*     */   private Canvas game;
/*     */   
/*     */   public SoundDriverHo(String[] aClips, Canvas game) {
/*  44 */     this.game = game;
/*     */     
/*  46 */     System.out.println("<Sound Driver> LOADING SOUNDS");
/*     */     
/*  48 */     this.names = aClips;
/*     */     
/*  50 */     this.clips = new Clip[aClips.length];
/*  51 */     this.gainControl = new FloatControl[aClips.length];
/*  52 */     this.framePosition = new int[aClips.length];
/*     */     try {
/*  54 */       AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
/*  55 */           -1.0F, 
/*  56 */           16, 2, 4, 
/*  57 */           -1.0F, true);
/*  58 */       DataLine.Info info = new DataLine.Info(Clip.class, format);
/*     */       
/*  60 */       for (int i = 0; i < this.clips.length; i++)
/*     */       {
/*     */ 
/*     */         
/*  64 */         InputStream resource = game.getClass().getResourceAsStream(aClips[i]);
/*  65 */         BufferedInputStream stream = new BufferedInputStream(resource);
/*  66 */         AudioInputStream soundIn = AudioSystem.getAudioInputStream(stream);
/*  67 */         this.clips[i] = (Clip)AudioSystem.getLine(info);
/*     */         
/*  69 */         this.clips[i].open(soundIn);
/*  70 */         this.gainControl[i] = (FloatControl)this.clips[i].getControl(FloatControl.Type.MASTER_GAIN);
/*  71 */         System.out.println("<Sound Driver> " + aClips[i]);
/*     */       }
/*     */     
/*  74 */     } catch (UnsupportedAudioFileException ex) {
/*  75 */       System.out.println("Unsupported Audio File");
/*  76 */     } catch (LineUnavailableException ex) {
/*  77 */       System.out.println("Line Unavailable");
/*  78 */     } catch (IOException ex) {
/*  79 */       System.out.println("IO Error" + ex);
/*     */     } 
/*     */     
/*  82 */     System.out.println("<Sound Driver> SOUNDS LOADED");
/*     */   }
/*     */   
/*     */   public int getIndex(String clipName) {
/*  86 */     for (int i = 0; i < this.names.length; i++) {
/*  87 */       if (this.names[i].equals(clipName)) return i; 
/*     */     } 
/*  89 */     System.out.println("<Sound Driver> String is not an index!");
/*  90 */     return -1;
/*     */   }
/*     */   
/*     */   public int numSongs() {
/*  94 */     return this.clips.length;
/*     */   }
/*     */   
/*     */   public String getString(int index) {
/*  98 */     return this.names[index];
/*     */   }
/*     */   
/*     */   public void play(int value) {
/* 102 */     this.clips[value].stop();
/* 103 */     this.clips[value].setFramePosition(0);
/* 104 */     this.clips[value].start();
/*     */   }
/*     */   public void play(String clipName) {
/* 107 */     play(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public void loop(int value) {
/* 111 */     this.clips[value].stop();
/* 112 */     this.clips[value].setFramePosition(0);
/* 113 */     this.clips[value].loop(-1);
/*     */   }
/*     */   public void loop(String clipName) {
/* 116 */     loop(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public void stop(int value) {
/* 120 */     this.clips[value].stop();
/*     */   }
/*     */   public void stop(String clipName) {
/* 123 */     stop(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public void pause(int value) {
/* 127 */     this.framePosition[value] = this.clips[value].getFramePosition();
/* 128 */     this.clips[value].stop();
/*     */   }
/*     */   public void pause(String clipName) {
/* 131 */     pause(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public void resume(int value) {
/* 135 */     this.clips[value].setFramePosition(this.framePosition[value]);
/* 136 */     this.clips[value].start();
/*     */   }
/*     */   public void resume(String clipName) {
/* 139 */     resume(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public boolean isPlaying(int value) {
/* 143 */     return this.clips[value].isRunning();
/*     */   }
/*     */   public boolean isPlaying(String clipName) {
/* 146 */     return isPlaying(getIndex(clipName));
/*     */   }
/*     */   
/*     */   public void setVolume(int clipIndex, float volume) {
/* 150 */     this.gainControl[clipIndex].setValue(volume);
/*     */   }
/*     */   public void setVolume(String clipName, float volume) {
/* 153 */     setVolume(getIndex(clipName), volume);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setVolumeAll(float f) {
/* 158 */     for (int i = 0; i < this.clips.length; i++) {
/* 159 */       setVolume(i, f);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void stopAll() {
/* 165 */     for (int i = 0; i < this.clips.length; i++) {
/* 166 */       if (isPlaying(i))
/* 167 */         stop(i); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\seung\Downloads\SeungheeHan'sGame.jar!\Utility\SoundDriverHo.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */