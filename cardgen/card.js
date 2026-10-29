window.makeCard = async function(photoBlob, name, bullets, opts){
  opts = opts||{};
  const base = 'https://funnynafanya.github.io/test/cardgen/';
  const f7 = new FontFace('RC7', 'url('+base+'RobotoCond-700.ttf)'); const f4 = new FontFace('RC4', 'url('+base+'RobotoCond-400.ttf)');
  await f7.load(); await f4.load(); document.fonts.add(f7); document.fonts.add(f4);
  const tb = await (await fetch(base+'tpl.png')).blob(); const tpl = await createImageBitmap(tb);
  const ph = await createImageBitmap(photoBlob);
  const c = document.createElement('canvas'); c.width = tpl.width; c.height = tpl.height; const x = c.getContext('2d');
  x.drawImage(tpl,0,0);
  x.fillStyle='#fff'; x.fillRect(343,88,1107-343,577-88); x.fillRect(0,565,343,12);
  // photo cover fit, centering (0.5,0.25)
  let sx=0, sy=0, sw=ph.width, sh=ph.height; if(opts.crop){[sx,sy,sw,sh]=[opts.crop[0],opts.crop[1],opts.crop[2]-opts.crop[0],opts.crop[3]-opts.crop[1]];}
  const bw=324, bh=475, r=bw/bh;
  if(sw/sh > r){ const nw=sh*r; sx+= (sw-nw)*0.5; sw=nw; } else { const nh=sw/r; sy+= (sh-nh)*(opts.cy==null?0.25:opts.cy); sh=nh; }
  x.drawImage(ph,sx,sy,sw,sh,16,88,bw,bh);
  // name
  x.save(); x.font='56px RC7'; x.fillStyle='rgb(10,77,150)'; x.textBaseline='middle';
  const w=x.measureText(name).width; x.translate(725,130); x.transform(1,0,-0.22,1,0,0); x.fillText(name,-w/2,0); x.restore();
  x.fillStyle='rgb(5,144,184)'; x.beginPath(); x.roundRect(375,190,713,6,3); x.fill();
  const n=bullets.length; let top=243, step = n>=5?60:66; if(n>=6){top=236;step=54;}
  bullets.forEach((b,i)=>{ const y=top+i*step; x.drawImage(tpl,396,210,30,40,398,y-20,30,40);
    x.save(); x.font='27px RC4'; x.fillStyle='rgb(20,40,100)'; x.textBaseline='middle'; x.translate(455,y); x.transform(1,0,-0.18,1,0,0); x.fillText(b,0,0); x.restore(); });
  return await new Promise(res=>c.toBlob(res,'image/jpeg',0.92));
};
