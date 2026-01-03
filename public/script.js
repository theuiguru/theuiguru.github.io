fetch('https://raw.githubusercontent.com/theuiguru/api.ct/master/index.json')
.then(res => res.json())
.then(data => {
    let q = Math.floor(Math.random() * data.quotes.length);
    let p = Math.floor(Math.random() * data.projects.length);
    document.querySelector('.quote').textContent = data.quotes[q].quote;
    document.querySelector('.project').innerHTML = 
    'Look what I\'ve built:<br><a href="' + data.projects[p].url + '" target="_blank">' + data.projects[p].title + '</a>';
});