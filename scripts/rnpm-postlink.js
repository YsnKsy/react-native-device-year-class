const fs = require('fs');
const path = require('path');
const appBuildGradlePath = path.join('android', 'app', 'build.gradle');
const defaultCompileStatement = "compile 'com.facebook.device.yearclass:yearclass:2.0.0'";
const requiredCompileStatement = "compile 'com.facebook.device.yearclass:yearclass:2.0.01'";
let buildGradleContents = fs.readFileSync(appBuildGradlePath, 'utf8');
buildGradleContents = buildGradleContents.replace(defaultCompileStatement, requiredCompileStatement);
fs.writeFileSync(appBuildGradlePath, buildGradleContents);
