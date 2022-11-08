package com.example.tarea10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        vistaGraficos graficos = new vistaGraficos(this);
        setContentView(graficos);
    }

    public class vistaGraficos extends View {
        public vistaGraficos (Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint pintura = new Paint();
            pintura.setColor(Color.rgb(154, 205, 50));
            canvas.drawPaint(pintura);

            int ancho, alto;
            ancho = canvas.getWidth();
            alto = canvas.getHeight();
            //canvas.drawText("ancho " + ancho + " y alto " + alto, 80, 180, pintura);
            pintura.setTextAlign(Paint.Align.CENTER);

            //Local y Visitante
            pintura.setColor(Color.BLACK);
            pintura.setTextSize(50);
            canvas.drawText("LOCAL", ancho/2, 50, pintura);
            canvas.drawText("VISITANTE", ancho/2, alto-10, pintura);

            //Líneas
            pintura.setStrokeWidth(10);
            pintura.setColor(Color.WHITE);
                //verticales
            canvas.drawLine(50, 50, 50, alto-50, pintura);
            canvas.drawLine(ancho-50, 50, ancho-50, alto-50, pintura);
                //horizontales
            canvas.drawLine(50, 60, ancho-50,  60, pintura);
            canvas.drawLine(50, alto-60, ancho-50,  alto-60, pintura);
            canvas.drawLine(50, alto/2, ancho-50,  alto/2, pintura);

            //área penal
            pintura.setStrokeWidth(12);
            canvas.drawPoint(ancho/2, alto-220, pintura);
            canvas.drawPoint(ancho/2, 220, pintura);

            //Circulo centro
            pintura.setStrokeWidth(7);
            pintura.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(ancho/2, alto/2, 150, pintura);

            //Esquinas
            //Superior Izquierda
            RectF oval1 = new RectF(0, 0, 100, 110);
            canvas.drawArc(oval1, 0F, 90F, true, pintura);
            RectF oval2 = new RectF(ancho-100, 0, ancho, 110);
            canvas.drawArc(oval2, 90F, 90F, true, pintura);
            RectF oval3 = new RectF(0, alto-115, 100, alto);
            canvas.drawArc(oval3, 270F, 90F, true, pintura);
            RectF oval4 = new RectF(ancho-100, alto-115, ancho, alto);
            canvas.drawArc(oval4, 180F, 90F, true, pintura);

            //Arcos
            RectF oval5 = new RectF((ancho/3)+25, 220, (2*ancho/3)-25, 310);
            canvas.drawArc(oval5, 0F, 180F, true, pintura);
            RectF oval6 = new RectF((ancho/3)+25, alto-310, (2*ancho/3)-25, alto-220);
            canvas.drawArc(oval6, 180F, 180F, true, pintura);

            //área del portero
            RectF rectangulo1 = new RectF(ancho/4, 60, 3*ancho/4, 260);
            canvas.drawRect(rectangulo1, pintura);
            RectF rectangulo2 = new RectF(ancho/4, alto-260, 3*ancho/4, alto-60);
            canvas.drawRect(rectangulo2, pintura);
                //área chica
            RectF rectangulo3 = new RectF(ancho/3, 60, 2*ancho/3, 160);
            canvas.drawRect(rectangulo3, pintura);
            RectF rectangulo4 = new RectF(ancho/3, alto-160, 2*ancho/3, alto-60);
            canvas.drawRect(rectangulo4, pintura);

            //letras centro
            Path trazo = new Path();
            trazo.addCircle(ancho/2, alto/2, 170, Path.Direction.CCW);
            pintura.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawTextOnPath("UPIITA", trazo, 270, 30, pintura);

            trazo.addCircle(ancho/2, alto/2, 170, Path.Direction.CW);
            canvas.drawTextOnPath("IPN", trazo, -270, 30, pintura);
        }
    }
}