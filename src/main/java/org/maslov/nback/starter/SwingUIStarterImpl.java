package org.maslov.nback.starter;

import lombok.extern.slf4j.Slf4j;
import org.maslov.nback.starter.legacy.NBackApplication;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SwingUIStarterImpl {

  public SwingUIStarterImpl() {
    NBackApplication.main(new String[]{});
    log.info("In SwingUIStarterImpl");
  }
}
