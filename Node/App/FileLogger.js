import morgan from 'morgan';
import fs from 'fs';

const morganFormat = ":method :url :status :response-time ms";

const appendFileLogs = morgan(morganFormat, {
    stream: {
        write: (message) => {
            const logObjct = {
                method: message.split('')[0],
                url: message.split('')[1],
                status: message.split('')[2],
                responseTime: message.split('')[3],
            
            };
            fs.appendFile('App/access.log', JSON.stringify(logObjct) + '\n', (err) => {
                if (err) {
                    console.log(err);
                }
            })
        }
    }
});