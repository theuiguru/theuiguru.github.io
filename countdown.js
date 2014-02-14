function countdown() {
  now = new Date();
  kickoff = Date.parse("June 20, 2014 09:00:00");
  diff = kickoff - now;
  days = Math.floor( diff / (1000*60*60*24) );
  hours = Math.floor( diff / (1000*60*60) );
  mins = Math.floor( diff / (1000*60) );
  secs = Math.floor( diff / 1000 );
  dd = days;
  hh = hours - days  * 24;
  mm = mins  - hours * 60;
  ss = secs  - mins  * 60;
    document.getElementById("countdown").innerHTML =
        dd + ' days ' +
        hh + ' hours ' +
        mm + ' minutes ' +
        ss + ' seconds';
} setInterval(countdown, 1000 );
//<div id="countdown"></div>
