import fs from 'fs';
import fetch from 'node-fetch';

const BLOG_FEED = 'https://theuiguru.blogspot.com/feeds/posts/default?max-results=150&alt=json';
const OUTPUT_DIR = './src/content/posts/';

const sanitizeFilename = (str) =>
  str.toLowerCase().replace(/[^a-z0-9]+/g, '-').replace(/(^-|-$)/g, '');

async function run() {
  const res = await fetch(BLOG_FEED);
  const data = await res.json();
  const posts = data.feed.entry;

  for (const post of posts) {
    const title = post.title.$t;
    const slug = sanitizeFilename(title);
    const pubDate = post.published.$t;
    const content = post.content?.$t || post.summary?.$t || '';

    const md = `---
title: "${title}"
pubDate: "${pubDate}"
---

${content}
`;

    fs.writeFileSync(`${OUTPUT_DIR}${slug}.md`, md, 'utf-8');
    console.log(`Created ${slug}.md`);
  }
}

run();