function sendFormByEmail(e) {
  var email = "chriszine102@yahoo.com";
  var txt = "";
  for (var field in e.namedValues) {
    txt += field + ' :: ' + e.namedValues[field].toString() + "\n\n";
  }
  MailApp.sendEmail(email, "Website Form Submitted", txt);
}
