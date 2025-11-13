export function parsePubDate(pubDate) {
  if (!pubDate) return null;
  if (pubDate.includes('T')) {
    const date = new Date(pubDate);
    return isNaN(date) ? null : date;
  }
  const [year, month, day] = pubDate.split('-').map(Number);
  return new Date(year, month - 1, day);
}

export function formatPubDate(pubDate, locale = 'en-US', style = 'long') {
  const date = parsePubDate(pubDate);
  if (!date) return 'Invalid Date';

  const options =
    style === 'short'
      ? {
          timeZone: 'America/New_York', // or your preferred zone
          year: 'numeric',
          month: '2-digit',
          day: '2-digit',
        }
      : {
          timeZone: 'America/New_York',
          weekday: 'long',
          year: 'numeric',
          month: 'long',
          day: 'numeric',
        };

  return date.toLocaleDateString(locale, options);
}